package geometries;

import java.util.List;
import java.util.stream.Collectors;

import primitives.Point3D;
import primitives.Ray;

/**
 * Intersectable interface system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */

public interface Intersectable {

    /**
     * This method will find the intersections between a Ray and an geometry
     *
     * @param ray
     * @return list<Point3D>
     */

    default List<Point3D> findIntersections(Ray ray) {
        var geoList = findGeoIntersections(ray);
        return geoList == null ? null : geoList.stream().map(gp -> gp.point).collect(Collectors.toList());
    }

    public List<GeoPoint> findGeoIntersections(Ray ray);

    public static class GeoPoint {
        public Geometry geometry;
        public Point3D point;

        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            GeoPoint other = (GeoPoint) obj;
            return geometry == other.geometry && point.equals(other.point);

        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((geometry == null) ? 0 : geometry.hashCode());
            result = prime * result + ((point == null) ? 0 : point.hashCode());
            return result;
        }

    }
}
