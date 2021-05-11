package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 * RayTraceBase abstract class system
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public abstract class RayTraceBase {
    protected Scene scene;

    /**
     * constructor
     *
     * @param scene
     */
    protected RayTraceBase(Scene scene) {
        this.scene = scene;
    }

    /**
     * @param rays
     * @return Color
     */
    public abstract Color traceRay(Ray ray);

}
