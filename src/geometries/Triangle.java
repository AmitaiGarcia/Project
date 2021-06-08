package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

/**
 * Triangle class represents 2-dimensional Triangle in 3D Cartesian coordinate
 * system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public class Triangle extends Polygon {
    /**
     * list of Point3D using an ArrayList
     *
     */

    private List<Point3D> verticespol = new ArrayList<>();

    /**
     * constructor for the triangle
     * 
     * @param p1
     * @param p2
     * @param p3
     */
    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(p1, p2, p3);
        verticespol.add(new Point3D(p1.getX(), p1.getY(), p1.getZ()));
        verticespol.add(new Point3D(p2.getX(), p2.getY(), p2.getZ()));
        verticespol.add(new Point3D(p3.getX(), p3.getY(), p3.getZ()));
    }

    /**
     *
     * This method finds all intersection points between a Ray and the Triangle
     *
     * @param ray
     * @return List<GeoPoint>
     */
    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray) {
        List<GeoPoint> planeItersections = plane.findGeoIntersections(ray);
        if (planeItersections == null)
            return null;
        Point3D p0 = ray.getP0();
        Vector v = ray.getDir();

        Vector v1 = verticespol.get(0).subtract(p0);
        Vector v2 = verticespol.get(1).subtract(p0);
        Vector v3 = verticespol.get(2).subtract(p0);

        double N1 = v.dotProduct(v1.crossProduct(v2));
        if (isZero(N1))
            return null;
        double N2 = v.dotProduct(v2.crossProduct(v3));
        if (isZero(N2))
            return null;
        double N3 = v.dotProduct(v3.crossProduct(v1));
        if (isZero(N3))
            return null;
        // pt is inside if they have the same sign
        if ((N1 > 0 && N2 > 0 && N3 > 0) || (N1 < 0 && N2 < 0 && N3 < 0)) {
            planeItersections.get(0).geometry = this;
            return planeItersections;
        }
        return null;

    }

}