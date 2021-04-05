package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry {
    private Point3D p0;
    private Vector normal;

    public Plane(Point3D p0, Vector normal) {
        this.p0 = p0;
        this.normal = normal.normalized();
    }

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        p0 = p1;
        // TODO: the calc
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

        return null;
    }

}
