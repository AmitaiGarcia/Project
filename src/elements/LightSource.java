package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * Interface class called LightSource
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public interface LightSource {

    /**
     * GetIntensity function
     *
     * @param p
     * @return color
     */
    public Color getIntensity(Point3D p);

    /**
     * GetL function
     *
     * @param p
     * @return Vector
     */
    public Vector getL(Point3D p);

    double getDistance(Point3D point);

}
