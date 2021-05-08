package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {

    List<Intersectable> Geometries;

    public Geometries() {
        Geometries = new LinkedList<>();
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

    /**
     * Finds the intersection between a ray an the objects within the list.
     *
     * @param ray
     * @return List<Point3D>
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> result = null;
        for (Intersectable element : Geometries) {
            List<Point3D> elementList = element.findIntersections(ray);
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