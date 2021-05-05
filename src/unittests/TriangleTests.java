package unittests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TriangleTests {

	@Test
	public void normalTest() {

		Point3D p1 = new Point3D(1, 2, 1);
		Point3D p2 = new Point3D(-3, 0, 5);
		Point3D p3 = new Point3D(2, -2, -7);
		Vector v1 = p2.subtract(p1); // p1->p2
		Vector v2 = p3.subtract(p1); // p1->p3
		Triangle triangle = new Triangle(p1, p2, p3);
		Vector v3 = v1.crossProduct(v2); // expected
		v3.normalize();
		assertEquals("ERROR: TriangleTests normal wrong value", v3, triangle.getNormal(p1));

	}

	@Test

	public void findIntersectionsTest() {
		Triangle triangle = new Triangle(new Point3D(0, 0, 0), new Point3D(0, 0, 3), new Point3D(2, 0, 0));

		// ============ Equivalence Partitions Tests ==============

		// TC01:Inside Polygon/triangle (1 points)
		Point3D p2 = new Point3D(1, 0, 1);
		assertEquals("TC01: Failed triangle test ", List.of(p2),
				triangle.findIntersections(new Ray(new Point3D(1, -2, 1), new Vector(0, 4, 0))));

		// TC02:Outside against edge (0 points)
		assertNull("TC02: Failed triangle test",
				triangle.findIntersections(new Ray(new Point3D(1, -2, 2), new Vector(0, 4, 0))));
		// TC03:Outside against vertex (0 points)
		assertNull("TC03: Failed triangle test",
				triangle.findIntersections(new Ray(new Point3D(-1, -2, -1), new Vector(0, 4, 0))));

		// =============== Boundary Values Tests ==================

		// TC04: On edge (0 points)
		assertNull("TC04: Failed triangle test",
				triangle.findIntersections(new Ray(new Point3D(0, -1, 1), new Vector(0, 2, 0))));
		// TC05: In Vertex (0 points)
		assertNull("TC05: Failed triangle test",
				triangle.findIntersections(new Ray(new Point3D(0, -1, 3), new Vector(0, 2, 0))));
		// TC06: On edge's continuation (0 points)
		assertNull("TC06: Failed triangle test",
				triangle.findIntersections(new Ray(new Point3D(-0.75, -1, 3.98), new Vector(0, 2, 0))));

	}
}
