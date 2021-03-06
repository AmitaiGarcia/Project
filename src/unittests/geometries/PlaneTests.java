package unittests.geometries;

import static org.junit.Assert.*;

import java.util.List;

import geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import org.junit.Test;

public class PlaneTests {
	Plane p1 = new Plane(new Point3D(0, 0, 0), new Point3D(1, 2, 0), new Point3D(2, 1, 0));

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testNormal() {
		// ============ Equivalence Partitions Tests ==============
		Vector normalvec = p1.getNormal();
		Vector vec = new Vector(0, 0, 1);
		Vector Reversed = new Vector(0, 0, -1);
		assertTrue("Plane TestNormal Failed", normalvec.equals(vec) || normalvec.equals(Reversed));

	}

	@Test
	/**
	 * Test method for {@link geometries.Plane#findIntersections(primitives.Ray)}.
	 */
	public void findIntersections() {
		Plane p2 = new Plane(new Point3D(-2, 0, 0), new Point3D(0, 0, 3), new Point3D(2, 0, 2));
		// ============ Equivalence Partitions Tests ==============
		// TC01: Ray intersects the plane
		Ray r1 = new Ray(new Point3D(0, -4, 3), new Vector(0, 1, 0));
		assertEquals("Plane TC01: Ray intersects plane failed", List.of(new Point3D(0, 0, 3)),
				p2.findIntersections(r1));

		// TC02: Ray does not intersect the plane
		Ray r2 = new Ray(new Point3D(0, 2, 6), new Vector(1, 1, 2));
		assertNull("Plane TC02: Ray intersects plane failed", p2.findIntersections(r2));

		// =============== Boundary Values Tests ==================
		// TC03: Ray is parallel to the plane (included in the plane)
		Ray r3 = new Ray(new Point3D(0, 2, 0), new Vector(0, 0, 1));
		assertNull("Plane TC03: Ray intersects plane failed", p2.findIntersections(r3));

		// TC04: Ray is parallel to the plane (not included in the plane)
		Ray r4 = new Ray(new Point3D(1, 1, 1), new Vector(0, 0, 1));
		assertNull("Plane TC04: Ray intersects plane failed", p2.findIntersections(r4));

		// TC05: Ray is orthogonal to the plane (before the plane)
		Ray r5 = new Ray(new Point3D(2, -2, 2), new Vector(0, 1, 0));
		assertEquals("Plane TC05: Ray intersects plane failed", List.of(new Point3D(2, 0, 2)),
				p2.findIntersections(r5));

		// TC06: Ray is orthogonal to the plane (in the plane)
		Ray r6 = new Ray(new Point3D(0, 2, 0), new Vector(0, 1, 0));
		assertNull("Plane TC06: Ray intersects plane failed", p2.findIntersections(r6));

		// TC07: Ray is orthogonal to the plane (after the plane)
		Ray r7 = new Ray(new Point3D(2, 2, 2), new Vector(0, 1, 0));
		assertNull("Plane TC07: Ray intersects plane failed", p2.findIntersections(r7));

		// TC08: p0 is in the plane, but not the ray
		Ray r8 = new Ray(new Point3D(2, 0, 2), new Vector(1, 1, 1));
		assertNull("Plane TC08: Ray intersects plane failed", p2.findIntersections(r8));

		// TC09: begins in the same point and is neither parallel or orthogonal
		Ray r9 = new Ray(p1.getP0(), new Vector(1, 1, 3));
		assertNull("Plane TC09: Ray intersects plane failed", p2.findIntersections(r9));

	}
}
