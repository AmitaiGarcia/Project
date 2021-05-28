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

    private Point3D position;
    private double kC;
    private double kL;
    private double kQ;

    /**
     * Constructor for PointLight
     *
     * @param colour
     * @param position
     * @param q
     * @param l
     * @param c
     */
    public PointLight(Color colour, Point3D position, double q, double l, double c) {
        super(colour);
        this.position = position;
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
        this(colorIntensity, position, 1d, 0d, 0d);
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

    @Override
    public Color getIntensity(Point3D p) {
        // TODO: check method in lecture Notes
        double dsquared = p.distanceSquared(position);
        double d = p.distance(position);

        return (intensity.reduce(kC + kL * d + kQ * dsquared));
    }

    @Override
    public Vector getL(Point3D p) {
        if (p.equals(position)) {
            return null;
        }
        return p.subtract(position).normalize();
    }

}
