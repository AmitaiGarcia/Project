package unittests;

import static org.junit.Assert.*;

import java.util.List;

import geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import org.hamcrest.Matcher;
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

	@Test
	public void findIntersections() {
		Plane plane = new Plane(new Point3D(0, 0, 0), new Vector(0, 0, 1));

		// ============ Equivalence Partitions Tests ==============
		// TC01: Ray intersects the plane
		List actual = plane.findIntersections(new Ray(new Point3D(0, 0, 0), new Vector(1, 2, 3)));
		assertEquals("List contains more or less then 1 intersections", 1, actual.size());

		// TC02: Ray does not intersect the plane
		// =============== Boundary Values Tests ==================
		// TC03: Ray is parallel to the plane (included in the plane)
		// TC04: Ray is parallel to the plane (not included in the plane)
		// TC05: Ray is orthogonal to the plane (before the plane)
		// TC06: Ray is orthogonal to the plane (in the plane)
		// TC07: Ray is orthogonal to the plane (after the plane)
		// TC08: p0 is in the plane, but not the ray
		// TC09: begins in the same point and is neither parallel or orthogonal
	}
}
