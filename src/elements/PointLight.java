package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * PointLight class that extends {@link Lights} and implements
 * {@link LightSource}
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public class PointLight extends Light implements LightSource {
    /**
     * position = position of the lightsource (pointlight) KC,KL,KQ are the
     * coeficients of the attenuation of the light source
     *
     */
    private Point3D position;
    private double kC;
    private double kL;
    private double kQ;
    private double radius;

    /**
     * Constructor for PointLight
     *
     * @param color
     * @param position
     * @param q
     * @param l
     * @param c
     */
    public PointLight(Color color, Point3D position, double q, double l, double c) {
        super(color);
        this.position = new Point3D(position);
        this.kC = c;
        this.kL = l;
        this.kQ = q;
    }

    /**
     * constructor for PointLight where kC,kL,kQ are defined as 1,0,0
     *
     * @param colorIntensity
     * @param position
     */
    public PointLight(Color colorIntensity, Point3D position) {
        this(colorIntensity, position, 0d, 0d, 1d);
    }

    /**
     * Setter method for kC
     *
     * @param kC
     * @return this
     */
    public PointLight setKC(double kC) {
        this.kC = kC;
        return this;
    }

    /**
     * Setter method for kL
     *
     * @param kL
     * @return this
     */
    public PointLight setKL(double kL) {
        this.kL = kL;
        return this;
    }

    /**
     * Setter method for kQ
     *
     * @param kQ
     * @return this
     */
    public PointLight setKQ(double kQ) {
        this.kQ = kQ;
        return this;
    }

    /**
     * Get intensityfunction for pointlight Io/Kc+Kl*d+Kq*d^2
     *
     * @param p
     * @return Color
     */
    @Override
    public Color getIntensity(Point3D p) {
        double dsquared = p.distanceSquared(position);
        double d = p.distance(position);

        return (intensity.reduce(kC + kL * d + kQ * dsquared));
    }

    /**
     * GetL function for the PointLight class
     *
     * @param p
     * @return Vector
     */
    @Override
    public Vector getL(Point3D p) {

        if (p.equals(position)) {
            return null;
        }
        return p.subtract(position).normalize();

    }

    /**
     * GetDistance function for the pointlight to a certain point
     *
     * @param point
     * @return double
     */
    @Override
    public double getDistance(Point3D point) {
        return position.distance(point);
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public PointLight setRadius(double radius) {
        this.radius = radius;
        return this;

    }

}
