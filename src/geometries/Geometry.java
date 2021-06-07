package geometries;

import primitives.Vector;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;

/**
 * Geometry interface system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public abstract class Geometry implements Intersectable {

    protected Color emmission;
    private Material material = new Material();

    protected Geometry() {
        emmission = new Color(java.awt.Color.BLACK);
    }

    protected Geometry(Color emmission) {
        emmission = new Color(emmission);

    }

    /**
     * get method for material
     *
     * @return Material
     */
    public Material getMaterial() {
        return this.material;
    }

    /**
     * set method for material that returns the object
     *
     * @param material
     * @return Geometry
     */
    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }

    /**
     * get method for emission
     *
     * @return Color
     */
    public Color getEmission() {
        return this.emmission;
    }

    /**
     * set method for emission and return the object
     *
     * @param emmission
     * @return Geometry
     */
    public Geometry setEmmission(Color emmission) {
        this.emmission = emmission;
        return this;
    }

    /**
     * getnormal method
     *
     * @param gp
     * @return Vector
     */
    public abstract Vector getNormal(Point3D gp);
}
