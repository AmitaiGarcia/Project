package unittests.primitives;

import static org.junit.Assert.*;
import primitives.Point3D;

import org.junit.Test;

public class Point3DTests {

    Point3D p1 = new Point3D(1, 0, 0);
    Point3D p2 = new Point3D(1, 1, 0);

    @Test
    public void distance() {

        assertTrue("Distance formula is not correct", p1.distance(p2) == 1d);
    }

}
