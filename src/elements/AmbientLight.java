package elements;

import primitives.Color;

/**
 * This light models the small amounts of light which reflected so many times
 * that their source is indeterminable. All geometry intersections will be
 * affected by at least this light.
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */

public class AmbientLight extends Light {

    public AmbientLight(Color intensity, double ka) {
        super(intensity.scale(ka));
    }

    public AmbientLight() {
        super(Color.BLACK);
    }

}
