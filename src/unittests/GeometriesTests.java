package unittests;

import geometries.Geometries;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the methods of the Geometries class.
 *
 * @author Amitai Rodrigues Garcia
 * @author Mengistu Kerew
 */

public class GeometriesTests {
    @Test
    public void testIntersect() {
        Ray ray = new Ray(new Point3D(0, 0, 0), new Vector(1, 0, 0));

        // Some shapes intersect
        Sphere intersectingSphere = new Sphere(new Point3D(2, 0, 0), 1);
        Plane nonIntersectingPlane = new Plane(new Point3D(0, 0, 1), new Vector(new Point3D(1, 0, 0)));
        Triangle intersectingTriangle = new Triangle(new Point3D(4, 0, 1), new Point3D(4, 1, -1),
                new Point3D(4, -1, -1));
        Geometries geometries = new Geometries(intersectingSphere, nonIntersectingPlane, intersectingTriangle);
        assertEquals("Wrong number of intersections when some shapes intersect",
                geometries.findIntersections(ray).size(), 3);

        // Boundary values test

        // Empty geometries
        geometries = new Geometries();
        assertNull("Empty geometries returned intersections.", geometries.findIntersections(ray));

        // No geometries intersect
        geometries = new Geometries(nonIntersectingPlane);
        assertNull("Expected no intersections when no geometries intersect.", geometries.findIntersections(ray));

        // Only one shape intersects
        geometries = new Geometries(intersectingSphere, nonIntersectingPlane);
        assertEquals("Wrong number of intersections when some shapes intersect",
                geometries.findIntersections(ray).size(), 2);

        // All shapes intersect
        geometries = new Geometries(intersectingSphere, intersectingTriangle);
        assertEquals("Wrong number of intersections when all shapes intersect",
                geometries.findIntersections(ray).size(), 3);
    }
}