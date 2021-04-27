package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Sphere;
import primitives.Point3D;
import primitives.Vector;

public class SphereTest {

	Sphere sphere = new Sphere(new Point3D(0, 0, 0), 1);

	@Test
	public void testGetNormal() {

		Vector normal = (sphere.getCenter()).subtract(new Point3D(0, 0, 1)).normalized();
		assertEquals("Sphere TestNormal Failed", sphere.getNormal(new Point3D(0, 0, 1)), normal);
	}

}
