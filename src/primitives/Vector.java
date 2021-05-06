package primitives;

import java.util.Objects;

public class Vector {
    Point3D head;

    // constructor
    public Vector(Point3D head) {
        if (head.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("Cannot use the zero vector");
        }
        this.head = head;
    }

    public Vector(double x, double y, double z) {
        this(new Point3D(x, y, z));
    }

    /**
     * @return Point3D
     */
    // get methods

    public Point3D getHead() {
        return this.head;
    }

    /**
     * @param gv.head.x.coord
     * @param gv.head.y.coord
     * @param gv.head.x.coord
     * @param gv.head.y.coord
     * @param scaler
     * @return Vector
     */
    // add and subtract vectors

    public Vector subtract(Vector gv) {// gv = given vector

        return new Vector(this.head.x.coord - gv.head.x.coord, this.head.y.coord - gv.head.y.coord,
                this.head.z.coord - gv.head.z.coord);
    }

    /**
     * @param gv.head.x.coord
     * @param gv.head.y.coord
     * @param scaler
     * @return Vector
     */
    public Vector add(Vector gv) {// gv = given vector
        return new Vector(this.head.x.coord + gv.head.x.coord, this.head.y.coord + gv.head.y.coord,
                this.head.z.coord + gv.head.z.coord);
    }

    /**
     * @param scaler
     * @return Vector
     */
    // scaler, dotproduct and crossproduct

    public Vector scale(double scaler) {

        return new Vector(this.head.x.coord * scaler, this.head.y.coord * scaler, this.head.z.coord * scaler);
    }

    /**
     * @param gv
     * @return double
     */
    public double dotProduct(Vector gv) {// gv = given vector
        return (this.head.x.coord * gv.head.x.coord + this.head.y.coord * gv.head.y.coord
                + this.head.z.coord * gv.head.z.coord);

        // if dotproduct is 0 = orthogonal
    }

    /**
     * @param gv
     * @return Vector
     */
    public Vector crossProduct(Vector gv) {

        return new Vector((head.y.coord * gv.head.z.coord) - (head.z.coord * gv.head.y.coord),
                (head.z.coord * gv.head.x.coord) - (head.x.coord * gv.head.z.coord),
                (head.x.coord * gv.head.y.coord) - (head.y.coord * gv.head.x.coord));
    }

    /**
     * @return double
     */
    // lengthSquared, Lenght

    public double lengthSquared() {
        return (head.x.coord * head.x.coord + head.y.coord * head.y.coord + head.z.coord * head.z.coord);
    }

    /**
     * @return double
     */
    public double length() {

        return Math.sqrt(lengthSquared());
    }

    /**
     * @return Vector
     */
    public Vector normalize() {
        double length = this.length();
        head = new Point3D(head.x.coord / length, head.y.coord / length, head.z.coord / length);
        return this;
    }

    /**
     * @return Vector
     */
    public Vector normalized() {
        double length = length();
        return new Vector(head.x.coord / length, head.y.coord / length, head.z.coord / length);
    }

    /**
     * @param o
     * @return boolean
     */
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

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(head);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return head.toString();
    }

}