package unittests.primitives;

import static org.junit.Assert.*;
import primitives.*;
import static java.lang.System.out;
import static primitives.Util.*;

import org.junit.Test;

public class VectorTests {

	Vector v1 = new Vector(1, 2, 3);
	Vector v2 = new Vector(-2, -4, -6);
	Vector v3 = new Vector(0, 3, -2);

	@Test
	public void testSubtract() {
		// ============ Equivalence Partitions Tests ==============
		// test: subtract random vector
		assertEquals("Subtraction Test Failure (1)", v1.subtract(new Vector(1, 1, 1)), new Vector(0, 1, 2));
	}

	@Test
	public void testAdd() {
		// ============ Equivalence Partitions Tests ==============
		// test: add random vector
		assertEquals("Addition Test Failure (1)", v1.add(new Vector(1, 1, 1)), new Vector(2, 3, 4));
		// =============== Boundary Values Tests ==================
		// test: add by itself
		assertEquals("Addition Test Failure (3)", v1.add(v1), new Vector(2, 4, 6));

	}

	@Test
	public void testScale() {
		// ============ Equivalence Partitions Tests ==============
		// test: Use positive scaler
		assertEquals("Scaler Test Failure (1)", v1.scale(2), new Vector(2, 4, 6));
		// test: Use Negative scaler
		assertEquals("Scaler Test Failure (2)", v1.scale(-1), new Vector(-1, -2, -3));
		// =============== Boundary Values Tests ==================

	}

	@Test
	public void testDotProduct() {

		assertTrue("ERROR: dotProduct() for orthogonal vectors is not zero", isZero(v1.dotProduct(v3)));
		assertTrue("ERROR: dotProduct() wrong value", isZero(v1.dotProduct(v2) + 28));

	}

	@Test
	public void testCrossProduct() {
		try { // test zero vector
			v1.crossProduct(v2);
			out.println("ERROR: crossProduct() for parallel vectors does not throw an exception");
		} catch (Exception e) {
		}
		Vector vr = v1.crossProduct(v3);
		assertTrue("ERROR: crossProduct() wrong result length", isZero(vr.length() - v1.length() * v3.length()));
		assertTrue("ERROR: crossProduct() result is not orthogonal to its operands",
				isZero(vr.dotProduct(v1)) || isZero(vr.dotProduct(v3)));

	}

	@Test
	public void testLengthSquared() {
		assertTrue("LengthSquared failed", isZero(v1.lengthSquared() - 14));

	}

	@Test
	public void testLength() {
		assertTrue("ERROR: length() wrong value", isZero(v1.length() - Math.sqrt(14)));

	}

	@Test
	public void testNormalize() {
		v1.normalize();
		assertEquals("", 1, v1.length(), 1e-10);
	}

	@Test
	public void testNormalized() {
		assertEquals("normalized Failure", v1.normalized(),
				new Vector(1 / v1.length(), 2 / v1.length(), 3 / v1.length()));

	}

}
