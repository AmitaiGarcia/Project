package unittests.geometries;

import geometries.Cylinder;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.*;

public class CylinderTests {

	@Test
	public void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: point on the body of the Cylinder
		Cylinder cy = new Cylinder(new Ray(Point3D.ZERO, new Vector(1, 0, 0)), 1, 2);
		Point3D p = new Point3D(1, 0, 1);
		assertEquals("Cylinder getNormal() wrong result", new Vector(0, 0, 1), cy.getNormal(p));

		// TC02: point on the lower base
		Point3D p4 = new Point3D(0, 0, 0.5);
		assertEquals("Cylinder getNormal() wrong result", new Vector(1, 0, 0), cy.getNormal(p4));

		// TC03:Point is on the upper base
		Point3D p1 = new Point3D(2, 0, 0.5);
		assertEquals("Cylinder getNormal() wrong result", new Vector(1, 0, 0), cy.getNormal(p1));

		// =============== Boundary Values Tests ==================

		// TC04:point between the body and the upper base
		Point3D p2 = new Point3D(2, 0, 1);
		assertEquals("Cylinder getNormal() wrong result", new Vector(1, 0, 0), cy.getNormal(p2));

		// TC05:point between the body and the lower base
		Point3D p3 = new Point3D(0, 0, 1);
		assertEquals("Cylinder getNormal() wrong result", new Vector(1, 0, 0), cy.getNormal(p3));

		// TC06:Point is in the center of lower base
		Point3D p6 = new Point3D(0, 0, 0);
		assertEquals("Cylinder getNormal() wrong result", new Vector(1, 0, 0), cy.getNormal(p6));

		// TC07:Point is in the center of lower base
		Point3D p7 = new Point3D(2, 0, 0);
		assertEquals("Cylinder getNormal() wrong result", new Vector(1, 0, 0), cy.getNormal(p7));
	}
}
