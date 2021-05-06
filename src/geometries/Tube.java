package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry {
    private Ray axisRay;
    private double radius;

    public Tube(Ray axisRay, double radius) {
        this.axisRay = axisRay;
        this.radius = radius;
    }

    /**
     * this method return the axisray which runs through the center of the tube
     * 
     * @return Ray
     */
    public Ray getAxisRay() {
        return this.axisRay;
    }

    /**
     * This method return the radius fromt he center of the tube to the edge
     * 
     * @return double
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" + " axisRay='" + getAxisRay() + "'" + ", radius='" + getRadius() + "'" + "}";
    }

    /**
     * This method return the normal vector to a tube
     * 
     * @param gp
     * @return Vector
     */
    @Override
    public Vector getNormal(Point3D gp) {

        Point3D o = axisRay.getP0();
        Vector v = axisRay.getDir();
        double t = gp.subtract(o).dotProduct(v);
        if (t != 0)
            o = o.add(v.scale(t));
        return gp.subtract(o).normalize();
    }

    /**
     * This method finds all the intersections between a given Ray and the tube (not
     * implemented yet)
     * 
     * @param ray
     * @return List<Point3D>
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        // TODO Auto-generated method stub
        return null;
    }

}
