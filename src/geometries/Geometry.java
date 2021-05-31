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
    private Material material;

    protected Geometry() {
        emmission = new Color(java.awt.Color.BLACK);
    }

    protected Geometry(Color emmission) {
        emmission = new Color(emmission);
    }

    public Material getMaterial() {
        return this.material;
    }

    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public Color getEmission() {
        return this.emmission;
    }

    public Geometry setEmmission(Color emmission) {
        this.emmission = emmission;
        return this;
    }

    public abstract Vector getNormal(Point3D gp);
}
