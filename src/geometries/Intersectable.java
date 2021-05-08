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

/**
 * This method will find the intersections between a Ray and an geometry
 *
 * @param ray
 * @return list<Point3D>
 */
public interface Intersectable {
    public List<Point3D> findIntersections(Ray ray);

}
