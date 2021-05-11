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

    @Override
    public Color traceRay(Ray ray) {

        List<Point3D> intersections = scene.geometries.findIntersections(ray);
        if (intersections == null || intersections.isEmpty()) {
            return scene.background;
        }

        return calcColor(ray.findClosestPoint(intersections));
    }

    private Color calcColor(Point3D point) {

        return scene.background;
    }

}
