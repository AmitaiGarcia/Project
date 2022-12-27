package geometries;

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
        Vector u = null;
        try {
            u = center.subtract(ray.getP0());
        } catch (Exception e) { // ray start in the center of the sphere
            return List.of(new GeoPoint(this, ray.getPoint(radius))); // only 1 intersection point in this case
        }
        double tm = alignZero(ray.getDir().dotProduct(u)); //// t_m = v * u
        double thSquared = (radius * radius) - (u.lengthSquared() - (tm * tm));

        if (alignZero(thSquared) <= 0) // the line is out of the sphere
            return null;

        double th = Math.sqrt(thSquared);
        double t2 = alignZero(tm + th);
        if (t2 <= 0)
            return null;

        double t1 = alignZero(tm - th);
        if (t1 > 0)
            return List.of(new GeoPoint(this, ray.getPoint(t1)), new GeoPoint(this, ray.getPoint(t2)));
        else
            return List.of(new GeoPoint(this, ray.getPoint(t2)));
    }

}
