package geometries;

import java.util.ArrayList;
import java.util.List;
import static primitives.Util.*;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Sphere class represents 3-dimensional Sphere in 3D Cartesian coordinate
 * system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */

public class Sphere extends Geometry {
    /**
     * center = center of the sphere radius = the radius of the sphere
     */
    private Point3D center;
    private double radius;

    /**
     * constructor for the sphere
     * 
     * @param center
     * @param radius
     */
    public Sphere(Point3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * This method return the center of the sphere
     *
     * @return Point3D
     */
    public Point3D getCenter() {
        return this.center;
    }

    /**
     * this method return the radius of the sphere
     *
     * @return double
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * This method calculates the normal bector using a given point (gp) subtracting
     * it from the center and normalizing it
     *
     * @param gp
     * @return Vector
     */
    @Override
    public Vector getNormal(Point3D gp) {

        return center.subtract(gp).normalized();
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" + " center='" + getCenter() + "'" + ", radius='" + getRadius() + "'" + "}";
    }

    /**
     * This method finds all the intersections between a given Ray and the sphere
     *
     * @param ray
     * @return List<Geopoint>
     */

    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray) {
        ArrayList<GeoPoint> intersectionsPoints = null;
        Vector u = new Vector(center.subtract(ray.getP0())); // u = O - p0
        double tm = ray.getDir().dotProduct(u); //// t_m = v * u
        double d = Math.sqrt(u.lengthSquared() - tm * tm); // d = sqrt(|u|^2 - t_m^2)
        double t = (alignZero(radius - d));
        if ((d < radius) && t != 0.0 && !((tm < 0) && (u.length() > radius))) {
            double th = Math.sqrt(radius * radius - d * d); //// th = sqrt(r^2 - d^2)
            double t1 = tm + th;
            Point3D p1 = new Point3D(ray.getPoint(t1));
            if (!p1.equals(ray.getP0())) {
                intersectionsPoints = new ArrayList<>();
                intersectionsPoints.add(new GeoPoint(this, p1));
            }
            if (!isZero(tm) && (tm >= th)) {
                double t2 = tm - th;
                Point3D p2 = new Point3D(ray.getPoint(t2));
                if (!p2.equals(ray.getP0())) {
                    if (intersectionsPoints.isEmpty()) {
                        intersectionsPoints = new ArrayList<>();
                    }
                    intersectionsPoints.add(new GeoPoint(this, p2));
                }
            }
        }
        return intersectionsPoints;
    }

}
