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

    public Vector subtract(Point3D gp) { // gp = given point
        return new Vector(new Point3D(x.coord - gp.x.coord, y.coord - gp.y.coord, z.coord - gp.z.coord));

    }

    public Point3D add(Vector gv) {// gv = given vector
        return new Point3D(this.x.coord + gv.head.x.coord, this.y.coord + gv.head.y.coord,
                this.z.coord + gv.head.z.coord);
    }

    public double distanceSquared(Point3D gp) { // gp = given point
        double dx = x.coord - gp.x.coord;
        double dy = y.coord - gp.y.coord;
        double dz = z.coord - gp.z.coord;
        return dx * dx + dy * dy + dz * dz;
    }

    public double distance(Point3D gp) { // gp = given point
        return Math.sqrt(distanceSquared(gp));
    }

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

}
