package renderer;

import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;
import primitives.Ray;
import scene.Scene;

public class Render {

    ImageWriter imagewriter;
    Scene scene;
    Camera camera;
    RayTraceBase raytrace;

    /**
     * This method returns a render and sets the imagewriter
     *
     * @param imagewriter
     * @return Render
     */
    public Render setImageWriter(ImageWriter imagewriter) {
        this.imagewriter = imagewriter;
        return this;
    }

    /**
     * This method returns a render and sets the scene
     *
     * @param scene
     * @return Render
     */
    public Render setScene(Scene scene) {
        this.scene = scene;
        return this;
    }

    /**
     * This method returns a render and sets the camera
     *
     * @param camera
     * @return Render
     */
    public Render setCamera(Camera camera) {
        this.camera = camera;
        return this;
    }

    /**
     * This method returns a render and sets the raytrace
     *
     * @param raytrace
     * @return Render
     */
    public Render setRayTrace(RayTraceBase raytrace) {
        this.raytrace = raytrace;
        return this;
    }

    /**
     * This method (for now) checks if all parameters are assigned (not null)
     */
    public void renderImage() {

        if (camera == null) {
            throw new MissingResourceException("Camera cannot be null", "Camera", "");
        }
        if (imagewriter == null) {
            throw new MissingResourceException("imagewriter cannot be null", "Imagewriter", "");
        }
        if (scene == null) {
            throw new MissingResourceException("scene cannot be null", "Scene", "");
        }
        if (raytrace == null) {
            throw new MissingResourceException("raytrace cannot be null", "raytrace", "");
        }
        // TODO: throw UnsupportedOperationException{};

        int nY = imagewriter.getNy();
        int nX = imagewriter.getNx();
        Ray vpray;
        Color pcolor;

        for (int yPixel = 1; yPixel <= nY; yPixel++) {
            for (int xPixel = 1; xPixel <= nX; xPixel++) {
                vpray = camera.constructRayThroughPixel(nX, nY, 1, 1);
                pcolor = raytrace.traceRay(vpray);
                imagewriter.writePixel(xPixel - 1, yPixel - 1, pcolor);

            }

        }
    }

    /**
     * This method paints the grid of a image
     *
     * @param interval
     * @param color
     */
    public void printGrid(int interval, Color color) {

        if (imagewriter == null) {
            throw new MissingResourceException("imagewriter cannot be null (PrintGrid)", "imagewriter", "");
        }
        int nY = imagewriter.getNy();
        int nX = imagewriter.getNx();

        // makes the vertical lines of the grid
        for (int xPixel = interval; xPixel < nX; xPixel += interval)
            for (int yPixel = 0; yPixel < nY; yPixel++)
                imagewriter.writePixel(xPixel, yPixel, color);

        // makes the horizontal lines of the grid
        for (int xPixel = 0; xPixel < nX; xPixel++)
            for (int yPixel = interval; yPixel < nY; yPixel += interval)
                imagewriter.writePixel(xPixel, yPixel, color);
    }

    public void writeToImage() {

        if (imagewriter == null) {
            throw new MissingResourceException("imagewriter cannot be null (WriteToImage)", "Imagewriter", "");
        }
        imagewriter.writeToImage();
    }
}
