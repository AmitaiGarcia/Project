package renderer;

import java.util.List;
import geometries.Intersectable.GeoPoint;

import primitives.Color;
import primitives.Ray;
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

        return calcColor(ray.findClosestGeoPoint(intersections));
    }

    /**
     * At this point this method returns the ambientlight color.
     *
     * @param point
     * @return Color
     */
    private Color calcColor(GeoPoint point) {

        return point.geometry.getEmmission().add(scene.ambientLight.getIntensity());
    }

    private Color calcColor(GeoPoint point, Ray ray) {

        return point.geometry.getEmmission().add(scene.ambientLight.getIntensity());
    }
}
