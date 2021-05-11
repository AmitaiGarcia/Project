package unittests.geometries;

import primitives.*;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Tube;

public class TubeTests {
	public final Ray ray = new Ray(new Point3D(1, 2, 3), new Vector(4, 5, 6));
	public final Tube tube = new Tube(ray, 3);

	@Test
	public void testNormal() {
		Vector test = tube.getNormal(new Point3D(30, 34, 44));
		Vector actual = new Vector(0.45542570253032255, 0.5702221763589954, 0.6836915233225969);
		assertEquals("Problem with the tube vector test", test, actual);
	}
}