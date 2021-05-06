package geometries;

import primitives.Point3D;

/**
 * Triangle class represents 2-dimensional Triangle in 3D Cartesian coordinate
 * system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public class Triangle extends Polygon {

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(p1, p2, p3);
    }
}
