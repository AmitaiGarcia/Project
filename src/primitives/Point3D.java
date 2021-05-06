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
     * @param gp.x.coord
     * @param gp.y.coord
     * @param gv.head.x.coord
     * @param gv.head.y.coord
     * @param o
     * @return Vector
     */
    public Vector subtract(Point3D gp) { // gp = given point
        return new Vector(new Point3D(x.coord - gp.x.coord, y.coord - gp.y.coord, z.coord - gp.z.coord));

    }

    /**
     * @param gv.head.x.coord
     * @param gv.head.y.coord
     * @param o
     * @return Point3D
     */
    public Point3D add(Vector gv) {// gv = given vector
        return new Point3D(this.x.coord + gv.head.x.coord, this.y.coord + gv.head.y.coord,
                this.z.coord + gv.head.z.coord);
    }

    /**
     * @param o
     * @return double
     */
    public double distanceSquared(Point3D gp) { // gp = given point
        double dx = x.coord - gp.x.coord;
        double dy = y.coord - gp.y.coord;
        double dz = z.coord - gp.z.coord;
        return dx * dx + dy * dy + dz * dz;
    }

    /**
     * @param o
     * @return double
     */
    public double distance(Point3D gp) { // gp = given point
        return Math.sqrt(distanceSquared(gp));
    }

    /**
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

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    /**
     * @return double
     */
    public double getX() {
        return this.x.coord;
    }

    /**
     * @return double
     */
    public double getY() {
        return this.y.coord;
    }

    /**
     * @return double
     */
    public double getZ() {
        return this.z.coord;
    }

}
