package elements;

import primitives.Color;

public class AmbientLight {

    private Color intensity;

    public AmbientLight(Color Ia, double Ka) {

        this.intensity = Ia.scale(Ka);

    }

    public Color getIntensity() {
        return this.intensity;
    }

}
