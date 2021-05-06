package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Cylinder class represents 3-dimensional cylinder in 3D Cartesian coordinate
 * system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */

public class Cylinder extends Tube {
    private double height;

    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        this.height = height;
    }

    /**
     * @return double
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" + " axisRay='" + getAxisRay() + "'" + ", radius='" + getRadius() + "'" + " height='" + getHeight()
                + "'" + "}";
    }

    /**
     * @param gp
     * @return Vector
     */
    @Override
    public Vector getNormal(Point3D gp) {

        return null;
    }

}
