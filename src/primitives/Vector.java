package primitives;

import java.util.Objects;

public class Vector {
    Point3D head;

    // constructor
    public Vector(Point3D head) {
        this.head = head;
    }

    public Vector(Coordinate x, Coordinate y, Coordinate z) {
        Point3D point = new Point3D(x, y, z);
        if (point.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("Cannot use zero vector");
        }
        this.head = new Point3D(x, y, z);
    }

    public Vector(double x, double y, double z) {
        Point3D point = new Point3D(x, y, z);
        if (point.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("Cannot use zero vector");
        }
        this.head = new Point3D(x, y, z);
    }

    // add and subtract vectors

    public Vector subtract(Vector gv) {// gv = given vector

        return new Vector(this.head.x.coord - gv.head.x.coord, this.head.y.coord - gv.head.y.coord,
                this.head.z.coord - gv.head.z.coord);
    }

    public Vector add(Vector gv) {// gv = given vector
        return new Vector(this.head.x.coord + gv.head.x.coord, this.head.y.coord + gv.head.y.coord,
                this.head.z.coord + gv.head.z.coord);
    }

    // scaler, dotproduct and crossproduct

    public Vector scale(double scaler) {

        return new Vector(this.head.x.coord * scaler, this.head.y.coord * scaler, this.head.z.coord * scaler);
    }

    public double dotProduct(Vector gv) {// gv = given vector
        return (this.head.x.coord * gv.head.x.coord + this.head.y.coord * gv.head.y.coord
                + this.head.z.coord * gv.head.z.coord);

        // if dotproduct is 0 = orthogonal
    }

    public Vector crossProduct(Vector gv) {

        return new Vector((head.y.coord * gv.head.z.coord) - (head.z.coord * gv.head.y.coord),
                (head.z.coord * gv.head.x.coord) - (head.x.coord * gv.head.z.coord),
                (head.x.coord * gv.head.y.coord) - (head.y.coord * gv.head.x.coord));
    }

    // lengthSquared, Lenght

    public double lengthSquared() {
        return (head.x.coord * head.x.coord + head.y.coord * head.y.coord + head.z.coord * head.z.coord);
    }

    public double length() {

        return Math.sqrt(lengthSquared());
    }

    public Vector normalize() {
        double length = length();
        head.x = head.x / length();
        return this;
    }

    public Vector normalized() {
        double length = length();
        return new Vector(head.x.coord / length, head.y.coord / length, head.z.coord / length);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vector)) {
            return false;
        }
        Vector vector = (Vector) o;
        return Objects.equals(head, vector.head);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(head);
    }

    @Override
    public String toString() {
        return head.toString();
    }

}