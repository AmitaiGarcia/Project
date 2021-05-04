package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;

public class TriangleTests {

	@Test
	public void normalTest() {

		// ============ Equivalence Partitions Tests ==============

		Point3D p1 = new Point3D(1, 2, 1);
		Point3D p2 = new Point3D(-3, 0, 5);
		Point3D p3 = new Point3D(2, -2, -7);
		Vector v1 = new Vector(p2.subtract(p1)); // p1->p2
		Vector v2 = new Vector(p3.subtract(p1)); // p1->p3
		Triangle triangle = new Triangle(p1, p2, p3);
		Vector v3 = new Vector(v1.crossProduct(v2)); // expected
		v3.normalize();
		assertEquals("ERROR: TriangleTests normal wrong value", v3, triangle.getNormal(p1));

	}

}
