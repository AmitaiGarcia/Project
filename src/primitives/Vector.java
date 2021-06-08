package primitives;

import java.util.Objects;

public class Vector {
    /**
     * head = is the head of the vector
     */
    Point3D head;

    /**
     * constructor using only the head of the ray
     *
     * @param head
     */
    public Vector(Point3D head) {
        if (head.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("Cannot use the zero vector");
        }
        this.head = head;
    }

    /**
     * constructor using the x y z for the head point
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x, double y, double z) {
        this(new Point3D(x, y, z));
    }

    /**
     * copy constructor
     *
     * @param v
     */
    public Vector(Vector v) {
        this.head = v.head;
    }

    /**
     * @return Point3D
     */
    // get methods

    public Point3D getHead() {
        return this.head;
    }

    /**
     * This Method can subtract 1 vector from another
     *
     * @param gv
     * @return Vector
     */

    public Vector subtract(Vector gv) {// gv = given vector

        return new Vector(this.head.x.coord - gv.head.x.coord, this.head.y.coord - gv.head.y.coord,
                this.head.z.coord - gv.head.z.coord);
    }

    /**
     * This method adds 1 vector to another
     *
     * @param gv
     * @return Vector
     */
    public Vector add(Vector gv) {// gv = given vector
        return new Vector(this.head.x.coord + gv.head.x.coord, this.head.y.coord + gv.head.y.coord,
                this.head.z.coord + gv.head.z.coord);
    }

    /**
     * this method scales the vector by a scaler
     *
     * @param scaler
     * @return Vector
     */

    public Vector scale(double scaler) {

        return new Vector(this.head.x.coord * scaler, this.head.y.coord * scaler, this.head.z.coord * scaler);
    }

    /**
     * this method calculates the dotProduct between 2 vectors
     *
     * @param gv
     * @return double
     */
    public double dotProduct(Vector gv) {// gv = given vector
        return (this.head.x.coord * gv.head.x.coord + this.head.y.coord * gv.head.y.coord
                + this.head.z.coord * gv.head.z.coord);

        // if dotproduct is 0 = orthogonal
    }

    /**
     * This method calculates the crossproduct between 2 vectors
     *
     * @param gv
     * @return Vector
     */
    public Vector crossProduct(Vector gv) {

        return new Vector((head.y.coord * gv.head.z.coord) - (head.z.coord * gv.head.y.coord),
                (head.z.coord * gv.head.x.coord) - (head.x.coord * gv.head.z.coord),
                (head.x.coord * gv.head.y.coord) - (head.y.coord * gv.head.x.coord));
    }

    /**
     * This method calculates the length squared of the vector
     *
     * @return double
     */

    public double lengthSquared() {
        return (head.x.coord * head.x.coord + head.y.coord * head.y.coord + head.z.coord * head.z.coord);
    }

    /**
     * This method calculates the length without squaring the result
     *
     * @return double
     */
    public double length() {

        return Math.sqrt(lengthSquared());
    }

    /**
     * this method normalizes the vector but returns the vector unchanged
     *
     * @return Vector
     */
    public Vector normalize() {
        double length = this.length();
        head = new Point3D(head.x.coord / length, head.y.coord / length, head.z.coord / length);
        return this;
    }

    /**
     * this method normalized the vector and returnt he normalized vector
     *
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