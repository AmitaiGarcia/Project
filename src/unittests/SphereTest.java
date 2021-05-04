package unittests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class SphereTest {

    Sphere sphere = new Sphere(new Point3D(0, 0, 0), 1);

    @Test
    public void testGetNormal() {

        Vector normal = (sphere.getCenter()).subtract(new Point3D(0, 0, 1)).normalized();
        assertEquals("Sphere TestNormal Failed", sphere.getNormal(new Point3D(0, 0, 1)), normal);
    }

    @Test
    public void testFindIntersections() {
        Sphere sphere = new Sphere(new Point3D(1, 0, 0), 1);
        Sphere sphere2 = new Sphere(new Point3D(0, 0, 0), 2);

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertNull("Ray's line out of sphere",
                sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0))));

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
        Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
        List<Point3D> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(3, 1, 0)));
        assertEquals("Wrong number of points", 2, result.size());
        if (result.get(0).getX() > result.get(1).getX())
            result = List.of(result.get(1), result.get(0));
        assertEquals("Ray crosses sphere", List.of(p1, p2), result);

        // TC03: Ray starts inside the sphere (1 point)
        Point3D p3 = new Point3D(0, 0.82, -0.82);
        List<Point3D> result1 = sphere2.findIntersections(new Ray(new Point3D(0, 0, 1), new Vector(0, 1, 0)));
        assertEquals("TC03: Wrong number of points", 1, result.size());
        assertEquals("TC03: Ray crosses sphere", List.of(p3), result1);

        // TC04: Ray starts after the sphere (0 points)
        assertNull("TC04: Failed test, Ray starts after sphere",
                sphere2.findIntersections(new Ray(new Point3D(3, 0, 1), new Vector(4, 0, 1))));

        // =============== Boundary Values Tests ==================

        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        Point3D p4 = new Point3D(1.52, 1.24, 0.38);
        assertEquals("TC11: Wrong number of points", 1,
                (sphere2.findIntersections(new Ray(new Point3D(0, 2, 0), new Vector(4, 0, 1)))).size());
        assertEquals("TC11: Failed test", List.of(p4),
                sphere2.findIntersections(new Ray(new Point3D(0, 2, 0), new Vector(4, 0, 1))));
        // TC12: Ray starts at sphere and goes outside (0 points)
        assertNull("TC12: Failed test", sphere2.findIntersections(new Ray(new Point3D(0, 2, 0), new Vector(0, 3, 1))));

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        Point3D p5 = new Point3D(-2, 0, 0);
        Point3D p6 = new Point3D(2, 0, 0);
        assertEquals("TC13: Wrong number of points", 2,
                (sphere2.findIntersections(new Ray(new Point3D(-3, 0, 0), new Vector(1, 0, 0)))).size());
        assertEquals("TC13: Failed test", List.of(p6, p5),
                sphere2.findIntersections(new Ray(new Point3D(-3, 0, 0), new Vector(1, 0, 0))));
        // TC14: Ray starts at sphere and goes inside (1 points)
        Point3D p7 = new Point3D(-2, 0, 0);
        assertEquals("TC14: Wrong number of points", 1,
                (sphere2.findIntersections(new Ray(new Point3D(2, 0, 0), new Vector(-1, 0, 0)))).size());
        assertEquals("TC14: Failed test", List.of(p7),
                sphere2.findIntersections(new Ray(new Point3D(2, 0, 0), new Vector(-1, 0, 0))));
        // TC15: Ray starts inside (1 points)
        // TC16: Ray starts at the center (1 points)
        // TC17: Ray starts at sphere and goes outside (0 points)
        // TC18: Ray starts after sphere (0 points)

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        // TC20: Ray starts at the tangent point
        // TC21: Ray starts after the tangent point

        // **** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's
        // center line

    }

}
