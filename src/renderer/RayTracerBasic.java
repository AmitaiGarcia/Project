package renderer;

import java.util.List;
import static primitives.Util.*;

import elements.LightSource;
import geometries.Intersectable.GeoPoint;

import primitives.Color;
import primitives.Material;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class RayTracerBasic extends RayTraceBase {

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
     * At this point this method returns the ambientlight color.
     *
     * @param point
     * @return Color
     */

    private Color calcColor(GeoPoint point, Ray ray) {

        Color color = scene.ambientLight.getIntensity();
        color = color.add(point.geometry.getEmission());

        color = color.add(calcLocaleffects(point, ray));

        return color;

    }

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
            if (nl * nv > 0) {
                Color lightIntensity = light.getIntensity(point.point);
                color = color.add(calcDiffusive(kd, l, n, lightIntensity),
                        calcSpecular(ks, l, n, v, nShininess, lightIntensity));
            }
        }
        return color;
    }

    private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
        double ln = l.dotProduct(n);

        Vector r = l.subtract(n.scale(ln * 2)).normalized();

        double vr = -v.dotProduct(r);

        double max = Math.max(0, vr);
        double maxPow = Math.pow(max, nShininess);
        return lightIntensity.scale(maxPow * ks);
    }

    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {

        double ln = Math.abs(l.dotProduct(n));

        return lightIntensity.scale(ln * kd);
    }

}
