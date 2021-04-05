package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube {
    private double height;

    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return "{" + " axisRay='" + getAxisRay() + "'" + ", radius='" + getRadius() + "'" + " height='" + getHeight()
                + "'" + "}";
    }

    @Override
    public Vector getNormal(Point3D gp) {

        return null;
    }

}
