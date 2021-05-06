package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.isZero;

public class Plane implements Geometry {
    private Point3D p0;
    private Vector normal;

    public Plane(Point3D p0, Vector normal) {
        this.p0 = p0;
        this.normal = normal.normalized();
    }

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        this.p0 = p1;
        Vector v1 = p2.subtract(p1);
        Vector v2 = p3.subtract(p1);

        this.normal = v1.crossProduct(v2).normalized();
    }

    public Point3D getP0() {
        return this.p0;
    }

    public Vector getNormal() {

        return this.normal;
    }

    @Override
    public String toString() {
        return "{" + " p0='" + getP0() + "'" + ", normal='" + getNormal() + "'" + "}";
    }

    @Override
    public Vector getNormal(Point3D gp) {

        return this.normal;
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        // TODO Auto-generated method stub
        Point3D p0 = ray.getP0();
        Vector v = ray.getDir();
        


        Double tDenominator =normal.dotProduct(v);
        if(isZero(tDenominator)){
            //parallel VectorTests
            return null;
        }
        Double tNumerator = normal.dotProduct(v);
        Double t = alignZero(tNumerator / tDenominator);
        if (t < 0 ){
            return null;
        }else {
            return List.of(ray.getPoint(t));
        }
    
    }

    private Double alignZero(double d) {
        return null;
    }

}
