package geometries;

import primitives.Vector;
import primitives.Point3D;

/**
 * Geometry interface system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public interface Geometry extends Intersectable {

    public Vector getNormal(Point3D gp);
}
