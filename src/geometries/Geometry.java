package geometries;

import primitives.Vector;
import primitives.Color;
import primitives.Point3D;

/**
 * Geometry interface system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public abstract class Geometry implements Intersectable {

    protected Color emmission;

    public Geometry() {

        this.emmission = Color.BLACK;
    }

    public Color getEmmission() {
        return this.emmission;
    }

    public Geometry setEmmission(Color emmission) {
        this.emmission = emmission;
        return this;
    }

    public abstract Vector getNormal(Point3D gp);
}
