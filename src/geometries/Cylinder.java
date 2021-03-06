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
    /**
     * height = the height of the cylinder
     */
    private double height;

    /**
     * constructor that uses the super constructor of tube to set the cylinder class
     * 
     * @param axisRay
     * @param radius
     * @param height
     */
    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        this.height = height;
    }

    /**
     * this method return the height of the cylinder
     *
     * @return double
     */
    public double getHeight() {
        return this.height;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "{" + " axisRay='" + getAxisRay() + "'" + ", radius='" + getRadius() + "'" + " height='" + getHeight()
                + "'" + "}";
    }

    /**
     * This method calculates and returns the normal vector (not implemented)
     *
     * @param gp
     * @return Vector
     */
    @Override
    public Vector getNormal(Point3D gp) {

        return null;
    }

}
