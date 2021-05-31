package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import static primitives.Util.*;

/**
 * SpotLight class that extends {@link PointLight}
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public class SpotLight extends PointLight {
    private Vector direction;

    /**
     * constructor for Spotlight class
     *
     * @param color
     * @param position
     * @param direction
     * @param q
     * @param l
     * @param c
     */
    public SpotLight(Color color, Point3D position, Vector direction, double q, double l, double c) {
        super(color, position, q, l, c);
        this.direction = direction.normalized();

    }

    /**
     * constructor for Spotlight class where Kc is 1 by default and Kq and Kl are 0
     * by default
     *
     * @param color
     * @param position
     * @param direction
     * @param q
     * @param l
     * @param c
     */
    public SpotLight(Color color, Point3D position, Vector direction) {
        this(color, position, direction, 0d, 0d, 1d);
    }

    /**
     * Get intensity method for the SpotLight class
     * 
     * @param p
     * @return Color
     */
    @Override
    public Color getIntensity(Point3D p) {
        double projection = direction.dotProduct(getL(p));

        if (isZero(projection)) {
            return Color.BLACK;
        }
        double factor = Math.max(0, projection);
        Color pointlightIntensity = super.getIntensity(p);

        return (pointlightIntensity.scale(factor));
    }

}
