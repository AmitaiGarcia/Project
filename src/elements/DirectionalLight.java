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
    /**
     * direction = direction vector for the light
     */
    private Vector direction;
    private double radius = 0;

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

    /**
     * get intensity method for the DirectionalLight class
     *
     * @param p
     * @return Color
     */
    @Override
    public Color getIntensity(Point3D p) {
        return super.getIntensity();
    }

    /**
     * GetL method for the DirectionalLight class
     *
     * @param p
     * @return Vector
     */
    @Override
    public Vector getL(Point3D p) {
        return direction;
    }

    /**
     * GetDistance method for the DirectionalLight class
     *
     * @param p
     * @return Vector
     */
    @Override
    public double getDistance(Point3D point) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public DirectionalLight setRadius(double radius) {
        this.radius = radius;
        return this;

    }

}
