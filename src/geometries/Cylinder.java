package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.*;

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
     * This method calculates and returns the normal vector
     *
     * @param gp
     * @return Vector
     */
    @Override
    public Vector getNormal(Point3D gp) {

        Point3D p0 = getAxisRay().getP0();
        Vector opposite = getAxisRay().getDir();

        if (p0.equals(gp))
            return opposite;

        Vector hypotenuse = gp.subtract(p0);
        double t = hypotenuse.dotProduct(opposite);
        if (isZero(t - height) || isZero(t)) // point is on the bases of the cylinder
            return opposite; // axisRay vector

        Point3D center = p0.add(opposite.scale(t));
        return gp.subtract(center);
    }
}
