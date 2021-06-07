package primitives;

import java.util.List;
import java.util.Objects;
import geometries.Intersectable.GeoPoint;

public class Ray {
    public Point3D p0;
    public Vector dir;
    Vector norm;
    private static final double DELTA = 0.1;

    public Ray(Point3D p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir.normalized();
    }

    /**
     * constructor getting a point and normal (of a geometry) and moves the point in
     * the normal's direction with delta length, and that point is the source of the
     * built ray, and getting the direction of the ray (of the shadow ray,
     * reflection or refraction)
     *
     * @param point     base place
     * @param normal    direction to move the source point to
     * @param direction of the ray to build
     */
    public Ray(Point3D head, Vector direction, Vector normal) {

        Vector delta = normal.scale(normal.dotProduct(direction) >= 0 ? DELTA : -DELTA);
        this.p0 = head.add(delta);
        this.dir = direction.normalized();

    }

    /**
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ray)) {
            return false;
        }
        Ray ray = (Ray) o;
        return Objects.equals(p0, ray.p0) && Objects.equals(dir, ray.dir) && Objects.equals(norm, ray.norm);
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(p0, dir, norm);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" + " p0='" + p0 + "'" + ", dir='" + dir + "'" + ", norm='" + norm + "'" + "}";
    }

    /**
     * @return Point3D
     */
    public Point3D getP0() {
        return this.p0;
    }

    /**
     * @return Vector
     */
    public Vector getDir() {
        return this.dir;
    }

    /**
     * @return Vector
     */
    public Vector getNorm() {
        return this.norm;
    }

    /**
     * @param t
     * @return Point3D
     */
    public Point3D getPoint(double t) {
        return p0.add(dir.scale(t));
    }

    /**
     * This method will find the closest point to the ray's head (p0) from a list of
     * points
     *
     * @param list
     * @return Point3D
     */
    public Point3D findClosestPoint(List<Point3D> list) {

        if (list == null || list.isEmpty())
            return null;
        Point3D closest = list.get(0);
        for (Point3D point : list) {
            if (p0.distance(closest) > p0.distance(point))
                closest = point;
        }
        return closest;
    }

    public GeoPoint findClosestGeoPoint(List<GeoPoint> list) {

        if (list == null || list.isEmpty())
            return null;
        GeoPoint closest = list.get(0);
        for (GeoPoint point : list) {
            if (p0.distance(closest.point) > p0.distance(point.point))
                closest = point;
        }
        return closest;

    }

}
