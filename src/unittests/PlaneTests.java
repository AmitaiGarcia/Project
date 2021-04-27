package unittests;

import static org.junit.Assert.*;
import geometries.Plane;
import primitives.Point3D;
import primitives.Vector;

import org.junit.Test;

public class PlaneTests {
	Plane p1 = new Plane(new Point3D(0, 0, 0), new Point3D(1, 2, 0), new Point3D(2, 1, 0));

	@Test
	public void testNormal() {
		// ============ Equivalence Partitions Tests ==============
		Vector normalvec = p1.getNormal();
		Vector vec = new Vector(0, 0, 1);
		Vector Reversed = new Vector(0, 0, -1);
		assertTrue("Plane TestNormal Failed", normalvec.equals(vec) || normalvec.equals(Reversed));

	}

}
