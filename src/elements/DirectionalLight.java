package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * DirectionalLight class that extends {@link Lights} and implements
 * {@link LightSource}
 *
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public class DirectionalLight extends Light implements LightSource {
    private Vector direction;

    /**
     * constructor for DirectionalLights
     *
     * @param color
     * @param direction
     */
    public DirectionalLight(Color color, Vector direction) {
        super(color);
        this.direction = direction.normalized();
    }

    @Override
    public Color getIntensity(Point3D p) {
        return super.getIntensity();
    }

    @Override
    public Vector getL(Point3D p) {
        return direction;
    }
}
