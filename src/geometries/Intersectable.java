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

    /**
     * This method created a list of all the geointersections betwen a ray and a
     * geometry
     *
     * @param ray
     * @return a list of GeoPoints
     */
    public List<GeoPoint> findGeoIntersections(Ray ray);

    /**
     * Geopoint class
     */
    public static class GeoPoint {
        /**
         * geometry = the geometry used point = the point of the GeoPoint
         */
        public Geometry geometry;
        public Point3D point;

        /**
         * constructor for the GeoPoint
         *
         * @param geometry
         * @param point
         */
        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }

        /**
         * this method check if the GeoPoint is equal to the other GeoPoint
         *
         * @param obj
         * @return boolean
         */
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

        /**
         *
         * @return null
         */
        public Point3D getPoint() {
            return null;
        }

    }
}
