package unittests.elements;

import elements.Camera;
import geometries.Intersectable;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * we test the Intersection between package geometry and ray to the camera in 3D
 * Cartesian coordinate
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */
public class IntersectionTests {
    Camera cam1 = new Camera(Point3D.ZERO, new Vector(0, 1, 0), new Vector(0, 0, 1));
    Camera cam2 = new Camera(new Point3D(0, 0, -0.5), new Vector(0, 1, 0), new Vector(0, 0, 1));

    /**
     * the func finds amount of intersections between a geometry and a camera
     *
     * @param geometry the geometry to intersect
     * @param expected expected amount of intersections
     * @param cam      the camera to generate the rays from
     */
    private void intersections(Intersectable geometry, int expected, Camera cam) {
        List<Point3D> results = null;
        int count = 0;
        // w X h--- 3 X 3
        int Nx = 3;
        int Ny = 3;
        cam.setDistance(1);
        cam.setViewPlaneSize(3, 3);
        for (int i = 0; i < Ny; ++i) {
            for (int j = 0; j < Nx; ++j) {
                results = geometry.findIntersections(cam.constructRayThroughPixel(Nx, Ny, j, i));
                if (results != null)
                    count += results.size();
            }
        }
        assertEquals("not good", expected, count);
    }

    /**
     * Tests to intersect a sphere from a camera through a viewplane
     */
    @Test
    public void constructRayThroughPixelWithSphere() {
        // TC01 test of intersection with sphere when all the sphere are out from the
        // screen 3*3
        intersections(new Sphere(new Point3D(0, 0, 3), 1), 2, cam1);

        // TC02 test of intersection with sphere when the all screen are in sphere
        intersections(new Sphere(new Point3D(0, 0, 2.5), 2.5), 18, cam2);

        // TC03:part of screen are in the sphere
        intersections(new Sphere(new Point3D(0, 0, 2), 2), 10, cam2);

        // TC04:the sphere around the screen
        intersections(new Sphere(new Point3D(0, 0, 2), 4), 9, cam2);
    }

    /**
     * Tests to intersect a Plane from a camera through a viewplane
     */
    @Test
    public void constructRayThroughPixelWithPlane() {
        // TC01: Plane is parallel to view Plane (9 points)
        intersections(new Plane(new Point3D(0, 0, 3), new Vector(0, 0, 1)), 9, cam1);

        // TC02: Plane is not parallel to view Plane(9 points)
        intersections(new Plane(new Point3D(0.5, -1.5, 2), new Point3D(0, 0, 2.5), new Point3D(0, 1.5, 3)), 9, cam1);

        // TC03: Plane is not parallel to view Plane (6 points)
        intersections(new Plane(new Point3D(0.5, -2, 2), new Point3D(0, 0, 4), new Point3D(0, 2, 6)), 6, cam1);
    }

    /**
     * Tests to intersect a Triangle from a camera through a viewplane
     */
    @Test
    public void constructRayThroughPixelWithTriangle() {
        // TC01: when triangle are smaller than the screen
        intersections(new Triangle(new Point3D(0, -1, 2), new Point3D(1, 1, 2), new Point3D(-1, 1, 2)), 1, cam1);

        // TC02: when the triangle is bigger than the screen
        intersections(new Triangle(new Point3D(0, -20, 2), new Point3D(1, 1, 2), new Point3D(-1, 1, 2)), 2, cam1);

    }
}
