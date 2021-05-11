package unittests.primitives;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class RayTests {
    @Test
    public void findClosestPointTest() {

        Ray ray = new Ray(new Point3D(0, 0, 0), new Vector(1, 1, 1));
        List<Point3D> points = new ArrayList<>();

        points.add(new Point3D(2, 2, 2));
        points.add(new Point3D(1, 0, 0));
        points.add(new Point3D(5, 5, 5));
        // ============ Equivalence Partitions Tests ==============
        // TC01: point somewhere in the middle of the list is closest
        assertEquals("TC01: test failed wrong points found", ray.findClosestPoint(points), new Point3D(1, 0, 0));

        // =============== Boundary Values Tests ==================
        // TC02: send the function a empty list.
        points.clear();
        assertNull("TC02: Should return Null but found a point", ray.findClosestPoint(points));

        // TC03: first point in the list is closest
        points.add(new Point3D(1, 0, 0));
        points.add(new Point3D(5, 5, 5));
        assertEquals("TC03: first point in list is not the closest", ray.findClosestPoint(points),
                new Point3D(1, 0, 0));

        // TC04: last point in the list is closest
        points.add(new Point3D(0.5, 0, 0));
        assertEquals("TC04: last point in list is not the closest", ray.findClosestPoint(points),
                new Point3D(0.5, 0, 0));

    }
}
