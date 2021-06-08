package elements;

import primitives.Color;

/**
 * Abstract class named Light without permissions
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public abstract class Light {
    /** color = Color of the light */
    Color intensity;

    /**
     * constructor for the intensity of the light (color)
     * 
     * @param intensity
     */
    protected Light(Color intensity) {
        this.intensity = intensity;
    }

    /**
     * Getter method for Intensity in Light class
     *
     * @return Color
     */
    public Color getIntensity() {
        return this.intensity;
    }

}
