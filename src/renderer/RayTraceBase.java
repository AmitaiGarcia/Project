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
    /**
     * scene = the scene without any geometries in it
     */
    protected Scene scene;

    /**
     * constructor that sets the scene
     *
     * @param scene
     */
    protected RayTraceBase(Scene scene) {
        this.scene = scene;
    }

    /**
     * abstract method for traceRay
     *
     * @param rays
     * @return Color
     */
    public abstract Color traceRay(Ray ray);

}
