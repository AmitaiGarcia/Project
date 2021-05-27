package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {

    List<Intersectable> Geometries;

    public Geometries() {
        Geometries = new ArrayList<>();
    }

    /**
     * This method adds an object to the collection
     *
     * @param Geometries
     */
    public void add(Intersectable... Geometries) {
        for (Intersectable Item : Geometries) {
            this.Geometries.add(Item);
        }
    }

    /**
     * default constructor
     */
    public Geometries(Intersectable... Geometries) {
        this.Geometries = new LinkedList<>();
        for (Intersectable Item : Geometries) {
            add(Item);
        }
    }

    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray) {

        List<GeoPoint> result = null;
        for (Intersectable element : Geometries) {
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