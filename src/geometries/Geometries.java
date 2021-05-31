package geometries;

import primitives.Ray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {

    List<Intersectable> geometries;

    public Geometries() {
        geometries = new ArrayList<>();
    }

    /**
     * This method adds an object to the collection
     *
     * @param Geometries
     */
    public void add(Intersectable... Geometries) {
        for (Intersectable Item : Geometries) {
            this.geometries.add(Item);
        }
    }

    /**
     * default constructor
     */
    public Geometries(Intersectable... Geometries) {
        this.geometries = new LinkedList<>();
        for (Intersectable Item : Geometries) {
            add(Item);
        }
    }

    /**
     * This Method finds all the Intersections using a Geopoint
     * 
     * @param ray
     * @return List<GeoPoint>
     */
    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray) {

        List<GeoPoint> result = null;
        for (Intersectable element : geometries) {
            List<GeoPoint> elementList = element.findGeoIntersections(ray);
            if (elementList != null) {
                if (result == null) {
                    result = new LinkedList<>();
                }

                result.addAll(elementList);
            }
        }

        return result;
    }

}