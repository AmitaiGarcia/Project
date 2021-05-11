package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point3D;
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

        List<Point3D> intersections = scene.geometries.findIntersections(ray);
        if (intersections == null || intersections.isEmpty()) {
            return scene.background;
        }

        return calcColor(ray.findClosestPoint(intersections));
    }

    /**
     * At this point this method returns the ambientlight color.
     *
     * @param point
     * @return Color
     */
    private Color calcColor(Point3D point) {

        return scene.ambientLight.getIntensity();
    }

}
