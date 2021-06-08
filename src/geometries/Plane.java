package geometries;

import java.util.ArrayList;
import java.util.List;
import static primitives.Util.*;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.isZero;

/**
 * Plane class represents 2-dimensional Plane in 3D Cartesian coordinate system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */

public class Plane extends Geometry {
    /**
     * p0 = point on the plane normal = normal vector for the plane
     */
    private Point3D p0;
    private Vector normal;

    /**
     * This constructor creates a plane class with 1 point P0 and the normal vector
     *
     * @param p0
     * @param vector
     */
    public Plane(Point3D p0, Vector normal) {
        this.p0 = p0;
        this.normal = normal.normalized();
    }

    /**
     * This constructor creates a plane class with 3 given points
     *
     * @param p1
     * @param p2
     * @param p3
     */
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        this.p0 = p1;
        Vector v1 = p2.subtract(p1);
        Vector v2 = p3.subtract(p1);

        this.normal = v1.crossProduct(v2).normalized();
    }

    /**
     * This method return P0
     *
     * @return Point3D
     */
    public Point3D getP0() {
        return this.p0;
    }

    /**
     * This method returns the normal vector (parameter of the class)
     *
     * @return Vector
     */
    public Vector getNormal() {

        return this.normal;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" + " p0='" + getP0() + "'" + ", normal='" + getNormal() + "'" + "}";
    }

    /**
     * This method find the normal vector to a plane
     *
     * @param gp
     * @return Vector
     */
    @Override
    public Vector getNormal(Point3D gp) {

        return this.normal;
    }

    /**
     * This method finds all intersection points between a Ray and the plane
     *
     * @param ray
     * @return List<Geopoint>
     */

    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray) {

        Vector norm = this.getNormal(p0);
        Vector p0q0 = p0.subtract(ray.getP0());
        if (p0.equals(ray.getP0())) {
            throw new IllegalArgumentException("the points cant be equal");
        }

        if (isZero(norm.dotProduct(ray.getDir())))
            return null;

        double t = alignZero(norm.dotProduct(p0q0)) / (norm.dotProduct(ray.getDir()));
        if (t > 0) {
            Point3D endP = ray.getPoint(t);
            List<GeoPoint> intersections = new ArrayList<>();
            intersections.add(new GeoPoint(this, endP));
            return intersections;
        }
        return null;
    }

}
