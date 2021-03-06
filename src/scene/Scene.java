package scene;

import java.util.LinkedList;
import java.util.List;

import elements.AmbientLight;
import elements.LightSource;
import geometries.Geometries;
import primitives.Color;

public class Scene {
    /**
     * name = name of the scene background = background color of the scene
     * ambientLight = the ambientlight color of the scene geometries = the existing
     * geometries in the scene lights = the list of lightsources in the scene
     */
    public String name;
    public Color background;
    public AmbientLight ambientLight;
    public Geometries geometries;
    public List<LightSource> lights;

    /**
     * constructor the set the scene where background is black ambientlight is Black
     * geometries is a list of empty geometries light is a empty linkedlist in which
     * the lightsources will be places
     * 
     * @param sName
     */
    public Scene(String sName) {
        name = sName;
        background = Color.BLACK;
        ambientLight = new AmbientLight(Color.BLACK, 0);
        geometries = new Geometries();
        lights = new LinkedList<>();
    }

    /**
     * This method sets the lights parameter and returns the object
     *
     * @param lights
     * @return Scene
     */
    public Scene setLights(List<LightSource> lights) {
        this.lights = lights;
        return this;
    }

    /**
     * this method sets the background parameter and returns the object
     *
     * @param background
     * @return Scene
     */
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    /**
     * This method sets the Ambientlight parameter and returns the object
     *
     * @param ambientLight
     * @return Scene
     */
    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    /**
     * this method sets the geometries parameter and returns the object
     *
     * @param geometries
     * @return Scene
     */
    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }

}
