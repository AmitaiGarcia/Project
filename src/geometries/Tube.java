package geometries;

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

        Vector t = axisRay.p0.subtract(gp);
        double dotProduct = (axisRay.dir).dotProduct(t);
        return t.subtract(axisRay.dir.scale(dotProduct)).normalized();
    }

}
