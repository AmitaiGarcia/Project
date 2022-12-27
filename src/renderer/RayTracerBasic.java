package renderer;

import java.util.ArrayList;
import java.util.List;
import static primitives.Util.*;

import elements.LightSource;
import geometries.Intersectable.GeoPoint;
import java.util.Random;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class RayTracerBasic extends RayTraceBase {
    /**
     * DELTA:for the size of moving ray’s heads for shadow rays, MAX/MIN 2 contants
     * for the recursion top condition of reflaction/transparancy
     * MAX_CALC_COLOR_LEVEL:the maximum times to enter the recursion of calcColor
     * MIN_CALC_COLOR_K:the bound of the opacity to enter the recursion of calcColor
     */
    private static final double INITIAL_K = 1.0;
    private static final int MAX_CALC_COLOR_LEVEL = 10;
    private static final double MIN_CALC_COLOR_K = 0.001;
    private final int numrays;
    private static final Random RAND = new Random();

    public RayTracerBasic(Scene scene, int num) {
        super(scene);
        this.numrays = num;
    }

    /**
     * This method traces the ray and return the color of the closest point to the
     * head of the ray
     *
     * @param ray
     * @return Color
     */
    @Override
    public Color traceRay(Ray ray) {

        GeoPoint closestPoint = findClosestIntersection(ray);
        return closestPoint == null ? scene.background : calcColor(closestPoint, ray);
    }

    /**
     * calculate the color in a specific point according to model phong, calculated
     * by the color of the elements and geometries of the scene
     *
     * @param ray   the ray of camera to calculate the color of the point it
     *              intersects
     * @param Point the p air of geometry and point to calculate the color to
     * @return the color of the pixel according to model phong
     */

    private Color calcColor(GeoPoint point, Ray ray) {

        return calcColor(point, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K).add(scene.ambientLight.getIntensity());

    }

    /**
     * calculate the color in a specific point according to model phong
     *
     * @param intersection
     * @param ray
     * @param level
     * @param k
     * @return Color
     */
    private Color calcColor(GeoPoint intersection, Ray ray, int level, double k) {
        Color color = intersection.geometry.getEmission().add(calcLocaleffects(intersection, ray, k));
        return 1 == level ? color : color.add(calcGlobalEffects(intersection, ray.dir, level, k));

    }

    /**
     * @param gp
     * @param v
     * @param level
     * @param k
     * @return Color
     */
    private Color calcGlobalEffects(GeoPoint gp, Vector v, int level, double k) {
        Color color = Color.BLACK;
        Vector n = gp.geometry.getNormal(gp.point);
        Material material = gp.geometry.getMaterial();
        double kkr = k * material.kR;
        if (kkr > MIN_CALC_COLOR_K)
            color = calcGlobalEffect(constructReflectedRay(gp.point, v, n), level, material.kR, kkr);
        double kkt = k * material.kT;
        if (kkt > MIN_CALC_COLOR_K)
            color = color.add(calcGlobalEffect(constructRefractedRay(gp.point, v, n), level, material.kT, kkt));
        return color;

    }

    /**
     * @param ray
     * @param level
     * @param kx
     * @param kkx
     * @return Color
     */
    private Color calcGlobalEffect(Ray ray, int level, double kx, double kkx) {
        GeoPoint gp = findClosestIntersection(ray);
        return (gp == null ? scene.background : calcColor(gp, ray, level - 1, kkx).scale(kx));

    }

    /**
     * This is a helper method to calculate the color using the phong model
     *
     * @param point
     * @param ray
     * @return Color
     */
    private Color calcLocaleffects(GeoPoint point, Ray ray, double k) {
        Vector v = ray.getDir();
        Vector n = point.geometry.getNormal(point.point);
        double nv = alignZero(n.dotProduct(v));
        if (isZero(nv)) {
            return Color.BLACK;
        }
        Material material = point.geometry.getMaterial();
        int nShininess = material.nShininess;
        double kd = material.kD;
        double ks = material.kS;
        Color color = Color.BLACK;
        for (LightSource light : scene.lights) {

            Vector l = light.getL(point.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) {
                double ktr = transparency(light, l, n, point);
                if (ktr * k > MIN_CALC_COLOR_K) {

                    Color lightIntensity = light.getIntensity(point.point).scale(ktr);
                    color = color.add(calcDiffusive(kd, l, n, lightIntensity),
                            calcSpecular(ks, l, n, v, nShininess, lightIntensity));
                }

            }

        }
        return color;
    }

    /**
     *
     * this is a helper method that calculates specular part of the simple phong
     * model
     *
     * @param ks
     * @param l
     * @param n
     * @param v
     * @param nShininess
     * @param lightIntensity
     * @return Color
     */
    private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
        double ln = l.dotProduct(n);

        Vector r = l.subtract(n.scale(ln * 2)).normalized();

        double vr = -v.dotProduct(r);

        double max = Math.max(0, vr);
        double maxPow = Math.pow(max, nShininess);
        return lightIntensity.scale(maxPow * ks);
    }

    /**
     *
     * * this is a helper method that calculates Diffusive part of the simple phong
     * model
     *
     * @param kd
     * @param l
     * @param n
     * @param lightIntensity
     * @return Color
     */
    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {

        double ln = Math.abs(l.dotProduct(n));

        return lightIntensity.scale(ln * kd);
    }

    /**
     * before was the unshaded method. transparency method calculates the
     * transparency
     *
     * @param light
     * @param l
     * @param n
     * @param gpoint
     * @return boolean
     */
    private double transparency(Ray ray, GeoPoint geopoint, LightSource light) {
        // calculate the distance between the light source and the point
        double lightDistance = light.getDistance(geopoint.point);

        // check if there is geometries between the light and the point
        var intersections = scene.geometries.findGeoIntersections(ray);
        if (intersections == null)
            return 1.0;

        // if there is, calculate the amount of transparency of all of them
        double ktr = 1.0;
        for (GeoPoint gp : intersections) {
            if (alignZero(gp.point.distance(geopoint.point) - lightDistance) <= 0) {
                ktr *= gp.geometry.getMaterial().kT;
                if (ktr < MIN_CALC_COLOR_K)
                    return 0.0;
            }
        }
        return ktr;
    }

    /**
     * this method constructs the refracted rays
     *
     * @param point
     * @param direction
     * @param normal
     * @return Ray
     */
    public Ray constructRefractedRay(Point3D point, Vector direction, Vector normal) {
        return new Ray(point, direction, normal);
    }

    /**
     * this method constructs the reflections rays
     *
     * @param point
     * @param direction
     * @param normal
     * @return Ray
     */
    public Ray constructReflectedRay(Point3D point, Vector direction, Vector normal) {
        double vn = direction.dotProduct(normal);
        if (isZero(vn)) {
            return new Ray(point, direction, normal);
        }
        Vector reflectDir = direction.subtract(normal.scale(vn * 2));
        return new Ray(point, reflectDir, normal);
    }

    /**
     * from all the intersection points, this function find the closest point to the
     * any point and return it
     *
     * @param intersectionPoints the points that intersect the ray in a specific
     *                           pixel
     * @param point              to check the closest point to
     * @return the closest point to the screen, that it is the point from the
     *         intersection points
     */
    public GeoPoint getClosestPoint(Point3D point, List<GeoPoint> intersectionPoints) {
        // result is the closest point
        GeoPoint result = null;
        // minDist is the minimum destination
        double minDist = Double.MAX_VALUE;
        // currentDistance the distance of the actual point
        double currentDistance = 0;
        // this for scan the all points from the list and for every point it checks
        // if its distance is less than the last one
        for (GeoPoint geoPoint : intersectionPoints) {
            currentDistance = point.distance(geoPoint.point);
            if (currentDistance < minDist) {
                minDist = currentDistance;
                result = geoPoint;
            }
        }
        return result;
    }

    /**
     * find the closest intersection with a ray
     *
     * @param ray
     * @return the pair of point and its geometry
     */
    private GeoPoint findClosestIntersection(Ray ray) {
        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
        if (intersections == null)
            return null;
        return getClosestPoint(ray.getP0(), intersections);
    }

    /**
     * Calculate the new vector by a random number between radius and minus radius
     *
     * @param vector
     * @param radius
     * @return new vector
     */
    private static Vector randomVector(Ray ray, LightSource light) {

        double x = RAND.nextDouble() * 2 * light.getRadius() - light.getRadius();
        double y = RAND.nextDouble() * 2 * light.getRadius() - light.getRadius();
        Vector X;
        try {
            X = ray.dir.crossProduct(new Vector(0, 0, 1));
        } catch (IllegalArgumentException __) {
            X = ray.dir.crossProduct(new Vector(1, 0, 0));
        }

        Vector Y = ray.dir.crossProduct(X);

        double t = light.getDistance(ray.getP0());
        if (t == Double.POSITIVE_INFINITY) {
            t = 1000000;
        }
        Point3D Pc = ray.getPoint(t);
        Vector Xx = X.scale(x + 1);
        Vector Yy = Y.scale(y + 1);
        Point3D Pi = Pc.add(Xx).add(Yy);
        return Pi.subtract(ray.getP0());

    }

    /**
     * Creates a new ray by a starting point p0, and also receives a direction
     * vector and radius and calculates the random vector according to this
     *
     * @param ray
     * @return list of rays
     */

    public List<Ray> splitRay(Ray ray, LightSource light) {
        List<Ray> result = new ArrayList<>();
        result.add(ray);
        for (int i = 0; i < numrays; i++) {
            result.add(new Ray(ray.getP0(), (randomVector(ray, light))));
        }
        return result;
    }

    /**
     * Calculates the main ray and sends it to splitray function that creates a list
     * of rays and summarizes the transparency of each ray and then returns their
     * average to divide by the size of the list.
     *
     * @param light
     * @param l
     * @param n
     * @param geopoint
     * @return rays transparency average to divide by the size of the list.
     */
    private double transparency(LightSource light, Vector l, Vector n, GeoPoint geopoint) {
        Vector lightDirection = l.scale(-1);
        Ray lightRay = new Ray(geopoint.point, lightDirection, n);
        List<Ray> beam = splitRay(lightRay, light);
        double transparency = 0;
        for (Ray ray : beam) {
            transparency += transparency(ray, geopoint, light);
        }
        return alignZero(transparency / beam.size());
    }

}
