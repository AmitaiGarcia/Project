package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

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
        this.direction = direction;

    }

}
