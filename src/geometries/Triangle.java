package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Triangle extends Polygon {

    private List<Point3D> _vertices = new ArrayList<>();
    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(p1, p2, p3);
    }
    public List<Point3D>findIntersections(Ray ray){
        List<Point3D>planItersections = plane.findIntersections(ray);
        if(planItersections==null) return null;
        Point3D p0 = ray.getP0();
        Vector v = ray.getDir();

        Vector v1 = _vertices.get(0).subtract(p0);
        Vector v2 = _vertices.get(1).subtract(p0);
        Vector v3 = _vertices.get(2).subtract(p0);

        double t1 = v.dotProduct(v1.crossProduct(v2));
        if (isZero(t1)) return null;
        double t2 = v.dotProduct(v2.crossProduct(v3));
        if (isZero(t2)) return null;
        double t3 = v.dotProduct(v3.crossProduct(v1));
        if (isZero(t3)) return null;
        
    }
}