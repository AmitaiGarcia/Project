package primitives;

import java.util.Objects;

public class Point3D {
    public final Coordinate x;
    public final Coordinate y;
    public final Coordinate z;
    public static final Point3D ZERO = new Point3D(0, 0, 0);

    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D(double x, double y, double z) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    public Point3D(Point3D p) {
        this.x = new Coordinate(p.x);
        this.y = new Coordinate(p.y);
        this.z = new Coordinate(p.z);
    }

    /**
     * this method subtracts 1 vector from another vector
     *
     * @param gp
     * @return Vector
     */
    public Vector subtract(Point3D gp) { // gp = given point
        return new Vector(new Point3D(x.coord - gp.x.coord, y.coord - gp.y.coord, z.coord - gp.z.coord));

    }

    /**
     * this method adds 1 vector to another vector and returns a Point3D
     *
     * @param gv = given vector
     * @return Point3D
     */
    public Point3D add(Vector gv) {
        return new Point3D(this.x.coord + gv.head.x.coord, this.y.coord + gv.head.y.coord,
                this.z.coord + gv.head.z.coord);
    }

    /**
     * this method calculates the distance between 2 points and squares the result
     *
     * @param gp = given point
     * @return double
     */
    public double distanceSquared(Point3D gp) {
        double dx = x.coord - gp.x.coord;
        double dy = y.coord - gp.y.coord;
        double dz = z.coord - gp.z.coord;
        return dx * dx + dy * dy + dz * dz;
    }

    /**
     * this method calculates the distance between 2 points
     *
     * @param closest = given point
     * @return double
     */
    public double distance(Point3D closest) {
        return Math.sqrt(distanceSquared(closest));
    }

    /**
     * this method checks if one point is equal to another point
     *
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Point3D)) {
            return false;
        }
        Point3D point3D = (Point3D) o;
        return Objects.equals(x, point3D.x) && Objects.equals(y, point3D.y) && Objects.equals(z, point3D.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    /**
     * this method return the X.coordinate
     *
     * @return double
     */
    public double getX() {
        return this.x.coord;
    }

    /**
     * this method return the Y.coordinate
     *
     * @return double
     */
    public double getY() {
        return this.y.coord;
    }

    /**
     * this method return the Z.coordinate
     *
     * @return double
     */
    public double getZ() {
        return this.z.coord;
    }

}
