package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;

/**
 * Intersectable interface system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */

public interface Intersectable {
    public List<Point3D> findIntersections(Ray ray);

}
