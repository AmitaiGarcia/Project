package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere implements Geometry {
    private Point3D center;
    private double radius;

    public Sphere(Point3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point3D getCenter() {
        return this.center;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public Vector getNormal(Point3D gp) {

        return center.subtract(gp).normalized();
    }

    @Override
    public String toString() {
        return "{" + " center='" + getCenter() + "'" + ", radius='" + getRadius() + "'" + "}";
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        // TODO Auto-generated method stub
        return null;
    }

}
