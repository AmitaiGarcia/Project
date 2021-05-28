package elements;

import primitives.Color;

/**
 * Abstract class named Light without permissions
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public abstract class Light {
    /** Color of the light */
    Color intensity;

    /**
     * Getter method for Intensity in Light class
     *
     * @return Color
     */
    public Color getIntensity() {
        return this.intensity;
    }

}
