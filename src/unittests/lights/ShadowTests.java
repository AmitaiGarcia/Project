package unittests.lights;

import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

/**
 * @author Dan
 */
public class ShadowTests {
        private Scene scene = new Scene("Test scene");
        private Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 1, 0), new Vector(0, 0, -1)) //
                        .setViewPlaneSize(200, 200).setDistance(1000);

        /**
         * Produce a picture of a sphere and triangle with point light and shade
         */
        @Test
        public void sphereTriangleInitial() {
                scene.geometries.add( //
                                new Sphere(new Point3D(0, 0, -200), 60) //
                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setShininess(30)), //
                                new Triangle(new Point3D(-70, -40, 0), new Point3D(-40, -70, 0),
                                                new Point3D(-68, -68, -4)) //
                                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                                .setMaterial(new Material().setkD(0.5).setkS(0.5)
                                                                                .setShininess(30)) //
                );
                scene.lights.add( //
                                new SpotLight(new Color(400, 240, 0), new Point3D(-100, -100, 200),
                                                new Vector(1, 1, -3)) //
                                                                .setKL(1E-5).setKQ(1.5E-7));

                Render render = new Render(). //
                                setImageWriter(new ImageWriter("shadowSphereTriangleInitial", 400, 400)) //
                                .setCamera(camera) //
                                .setRayTrace(new RayTracerBasic(scene, 1));
                render.renderImage();
                render.writeToImage();
        }

        /**
         * Produce a picture of a two triangles lighted by a spot light with a Sphere
         * producing a shading
         */
        @Test
        public void trianglesSphere() {
                scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

                scene.geometries.add( //
                                new Triangle(new Point3D(-150, -150, -115), new Point3D(150, -150, -135),
                                                new Point3D(75, 75, -150)) //
                                                                .setMaterial(new Material().setkS(0.8)
                                                                                .setShininess(60)), //
                                new Triangle(new Point3D(-150, -150, -115), new Point3D(-70, 70, -140),
                                                new Point3D(75, 75, -150)) //
                                                                .setMaterial(new Material().setkS(0.8)
                                                                                .setShininess(60)), //
                                new Sphere(new Point3D(0, 0, -115), 30) //
                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setShininess(30)) //
                );
                scene.lights.add( //
                                new SpotLight(new Color(700, 400, 400), new Point3D(40, 40, 115),
                                                new Vector(-1, -1, -4)) //
                                                                .setKL(4E-4).setKQ(2E-5));

                Render render = new Render() //
                                .setImageWriter(new ImageWriter("shadowTrianglesSphere", 600, 600)) //
                                .setCamera(camera) //
                                .setRayTrace(new RayTracerBasic(scene, 1));
                render.renderImage();
                render.writeToImage();
        }

        @Test /**
               * Produce a picture of a sphere and triangle with point light and shade
               * changing triangle position further
               */
        public void sphereTriangleMove1() {
                scene.geometries.add( //
                                new Sphere(new Point3D(0, 0, -200), 60) //
                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setShininess(30)), //
                                new Triangle(new Point3D(-70, -40, 30), new Point3D(-40, -70, 30),
                                                new Point3D(-68, -68, 26)) //
                                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                                .setMaterial(new Material().setkD(0.5).setkS(0.5)
                                                                                .setShininess(30)) //
                );
                scene.lights.add( //
                                new SpotLight(new Color(400, 240, 0), new Point3D(-100, -100, 200),
                                                new Vector(1, 1, -3)) //
                                                                .setKL(1E-5).setKQ(1.5E-7));

                Render render = new Render(). //
                                setImageWriter(new ImageWriter("sphereTriangleMove1", 400, 400)) //
                                .setCamera(camera) //
                                .setRayTrace(new RayTracerBasic(scene, 1));
                render.renderImage();
                render.writeToImage();
        }

        @Test /**
               * Produce a picture of a sphere and triangle with point light and shade
               * changing triangle position closer
               */
        public void sphereTriangleMove2() {
                scene.geometries.add( //
                                new Sphere(new Point3D(0, 0, -200), 60) //
                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setShininess(30)), //
                                new Triangle(new Point3D(-40, -10, -20), new Point3D(-10, -40, -20),
                                                new Point3D(-38, -38, -24)) //
                                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                                .setMaterial(new Material().setkD(0.5).setkS(0.5)
                                                                                .setShininess(30)) //
                );
                scene.lights.add( //
                                new SpotLight(new Color(400, 240, 0), new Point3D(-100, -100, 200),
                                                new Vector(1, 1, -3)) //
                                                                .setKL(1E-5).setKQ(1.5E-7));

                Render render = new Render(). //
                                setImageWriter(new ImageWriter("sphereTriangleMove2", 400, 400)) //
                                .setCamera(camera) //
                                .setRayTrace(new RayTracerBasic(scene, 1));
                render.renderImage();
                render.writeToImage();
        }

        @Test /**
               * Produce a picture of a sphere and triangle with point light and shade
               * changing light further
               */
        public void sphereTriangleMove3() {
                scene.geometries.add( //
                                new Sphere(new Point3D(0, 0, -200), 60) //
                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setShininess(30)), //
                                new Triangle(new Point3D(-70, -40, 0), new Point3D(-40, -70, 0),
                                                new Point3D(-68, -68, -4)) //
                                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                                .setMaterial(new Material().setkD(0.5).setkS(0.5)
                                                                                .setShininess(30)) //
                );
                scene.lights.add( //
                                new SpotLight(new Color(400, 240, 0), new Point3D(-110, -110, 190),
                                                new Vector(1, 1, -3)) //
                                                                .setKL(1E-5).setKQ(1.5E-7));

                Render render = new Render(). //
                                setImageWriter(new ImageWriter("sphereTriangleMove3", 400, 400)) //
                                .setCamera(camera) //
                                .setRayTrace(new RayTracerBasic(scene, 1));
                render.renderImage();
                render.writeToImage();
        }

        @Test
        /**
         * Produce a picture of a sphere and triangle with point light and shade
         * changing light closer
         */
        public void sphereTriangleMove4() {
                scene.geometries.add( //
                                new Sphere(new Point3D(0, 0, -200), 60) //
                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                .setMaterial(new Material().setkD(0.5).setkS(0.5).setShininess(30)), //
                                new Triangle(new Point3D(-70, -40, 0), new Point3D(-40, -70, 0),
                                                new Point3D(-68, -68, -4)) //
                                                                .setEmmission(new Color(java.awt.Color.BLUE)) //
                                                                .setMaterial(new Material().setkD(0.5).setkS(0.5)
                                                                                .setShininess(30)) //
                );
                scene.lights.add( //
                                new SpotLight(new Color(400, 240, 0), new Point3D(-75, -75, 65), new Vector(1, 1, -3)) //
                                                .setKL(1E-5).setKQ(1.5E-7));

                Render render = new Render(). //
                                setImageWriter(new ImageWriter("sphereTriangleMove4", 400, 400)) //
                                .setCamera(camera) //
                                .setRayTrace(new RayTracerBasic(scene, 1));
                render.renderImage();
                render.writeToImage();
        }

}
