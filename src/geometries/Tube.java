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

    public Ray getAxisRay() {
        return this.axisRay;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public String toString() {
        return "{" + " axisRay='" + getAxisRay() + "'" + ", radius='" + getRadius() + "'" + "}";
    }

    @Override
    public Vector getNormal(Point3D gp) {

        Point3D o = axisRay.getP0();
        Vector v = axisRay.getDir();
        double t = gp.subtract(o).dotProduct(v);
        if (t != 0)
            o = o.add(v.scale(t));
        return gp.subtract(o).normalize();
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        // TODO Auto-generated method stub
        return null;
    }

}
