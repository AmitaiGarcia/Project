package geometries;

import java.util.List;
import static primitives.Util.*;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Tube extends Geometry {
    /**
     * axisRay = ray that shows the axis of the tube. radius = radius of the tube
     * from the axis
     */
    private Ray axisRay;
    private double radius;

    /**
     * constructor for the Tube
     *
     * @param axisRay
     * @param radius
     */
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
        if (!isZero(t))
            o = o.add(v.scale(t));
        return gp.subtract(o).normalize();
    }

    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray) {
        // TODO: implement
        return null;
    }

}
