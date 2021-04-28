package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;

public interface Intersectable {
    public List<Point3D> findIntersections(Ray ray);

}
