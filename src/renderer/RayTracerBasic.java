package renderer;

import java.util.List;
import static primitives.Util.*;

import elements.LightSource;
import geometries.Intersectable.GeoPoint;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class RayTracerBasic extends RayTraceBase {
    /**
     * for the size of moving ray’s heads for shadow rays
     */
    private static final double DELTA = 0.1;

    public RayTracerBasic(Scene scene) {
        super(scene);
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

        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
        if (intersections == null || intersections.isEmpty()) {
            return scene.background;
        }

        return calcColor(ray.findClosestGeoPoint(intersections), ray);
    }

    /**
     * This method calculates the color using the simple Phong model
     *
     * @param point
     * @param ray
     * @return Color
     */

    private Color calcColor(GeoPoint point, Ray ray) {

        Color color = scene.ambientLight.getIntensity();
        color = color.add(point.geometry.getEmission());

        color = color.add(calcLocaleffects(point, ray));

        return color;

    }

    /**
     * This is a helper method to calculate the color using the phong model
     *
     * @param point
     * @param ray
     * @return Color
     */
    private Color calcLocaleffects(GeoPoint point, Ray ray) {
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
            if (unshaded(light, l, n, point) && nl * nv > 0) {

                Color lightIntensity = light.getIntensity(point.point);
                color = color.add(calcDiffusive(kd, l, n, lightIntensity),
                        calcSpecular(ks, l, n, v, nShininess, lightIntensity));

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

    private boolean unshaded(LightSource light, Vector l, Vector n, GeoPoint gpoint) {
        Vector lightDirection = l.scale(-1);
        Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : -DELTA);
        Point3D point = gpoint.point.add(delta);
        Ray lightRay = new Ray(point, lightDirection);

        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);
        if (intersections == null)
            return true;
        double lightDistance = light.getDistance(gpoint.point);
        for (GeoPoint gp : intersections) {
            if (alignZero(gp.point.distance(gpoint.point) - lightDistance) <= 0)
                return false;
        }
        return true;
    }

}
