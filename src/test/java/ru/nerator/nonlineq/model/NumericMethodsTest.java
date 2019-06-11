package ru.nerator.nonlineq.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author nerator
 *
 */
class NumericMethodsTest {

	private static final double EPSILON = 1E-6;
	private static MyTuple resBisec, resSecant, resNewton, resIter;

	@BeforeAll
	static void setUpBeforeClass() {
		resBisec  = NumericMethods.rootBisec (1, 2, 7, 0.001);
		resSecant = NumericMethods.rootSecant(1, 2, 7, 0.001);
		resNewton = NumericMethods.rootNewton(1, 2, 7, 0.001);
		resIter   = NumericMethods.rootIter  (1, 2, 7, 0.001);
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.model.NumericMethods#func(double, int)}.
	 */
	@Test
	void testFunc() {
		assertEquals(-30.875, NumericMethods.func(-3.0, 7), EPSILON);
		assertEquals(-23.75 , NumericMethods.func(-2.0, 7), EPSILON);
		assertEquals(-16.5  , NumericMethods.func(-1.0, 7), EPSILON);
		assertEquals( -9.0  , NumericMethods.func( 0.0, 7), EPSILON);
		assertEquals( -1.0  , NumericMethods.func( 1.0, 7), EPSILON);
		assertEquals(  8.0  , NumericMethods.func( 2.0, 7), EPSILON);
		assertEquals( 19.0  , NumericMethods.func( 3.0, 7), EPSILON);
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.model.NumericMethods#derFunc(double, int)}.
	 */
	@Test
	void testDerFunc() {
		assertEquals( 7.086643, NumericMethods.derFunc(-3.0, 7), EPSILON);
		assertEquals( 7.173286, NumericMethods.derFunc(-2.0, 7), EPSILON);
		assertEquals( 7.346573, NumericMethods.derFunc(-1.0, 7), EPSILON);
		assertEquals( 7.693147, NumericMethods.derFunc( 0.0, 7), EPSILON);
		assertEquals( 8.386294, NumericMethods.derFunc( 1.0, 7), EPSILON);
		assertEquals( 9.772588, NumericMethods.derFunc( 2.0, 7), EPSILON);
		assertEquals(12.545177, NumericMethods.derFunc( 3.0, 7), EPSILON);
	}

	/**
	 * Test method for {@link #der2Func(double)}.
	 */
	@Test
	void testDer2Func() {
		assertEquals(0.060056, NumericMethods.der2Func(-3.0), EPSILON);
		assertEquals(0.120113, NumericMethods.der2Func(-2.0), EPSILON);
		assertEquals(0.240226, NumericMethods.der2Func(-1.0), EPSILON);
		assertEquals(0.480453, NumericMethods.der2Func( 0.0), EPSILON);
		assertEquals(0.960906, NumericMethods.der2Func( 1.0), EPSILON);
		assertEquals(1.921812, NumericMethods.der2Func( 2.0), EPSILON);
		assertEquals(3.843624, NumericMethods.der2Func( 3.0), EPSILON);
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.model.NumericMethods#phi(double, int)}.
	 */
	@Test
	void testPhi() {
		assertEquals(1.410714, NumericMethods.phi(-3.0, 7), EPSILON);
		assertEquals(1.392857, NumericMethods.phi(-2.0, 7), EPSILON);
		assertEquals(1.357142, NumericMethods.phi(-1.0, 7), EPSILON);
		assertEquals(1.285714, NumericMethods.phi( 0.0, 7), EPSILON);
		assertEquals(1.142857, NumericMethods.phi( 1.0, 7), EPSILON);
		assertEquals(0.857142, NumericMethods.phi( 2.0, 7), EPSILON);
		assertEquals(0.285714, NumericMethods.phi( 3.0, 7), EPSILON);
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.model.NumericMethods#derPhi(double, int)}.
	 */
	@Test
	void testDerPhi() {
		assertEquals(-0.012377, NumericMethods.derPhi(-3.0, 7), EPSILON);
		assertEquals(-0.024755, NumericMethods.derPhi(-2.0, 7), EPSILON);
		assertEquals(-0.049510, NumericMethods.derPhi(-1.0, 7), EPSILON);
		assertEquals(-0.099021, NumericMethods.derPhi( 0.0, 7), EPSILON);
		assertEquals(-0.198042, NumericMethods.derPhi( 1.0, 7), EPSILON);
		assertEquals(-0.396084, NumericMethods.derPhi( 2.0, 7), EPSILON);
		assertEquals(-0.792168, NumericMethods.derPhi( 3.0, 7), EPSILON);
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.model.NumericMethods#rootBisec(double, double, int, double)}.
	 */
	@Test
	void testRootBisec() {
		assertEquals( 1.118, resBisec.getRoot(), 0.001);
		assertEquals(10    , resBisec.getSteps());
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.model.NumericMethods#rootSecant(double, double, int, double)}.
	 */
	@Test
	void testRootSecant() {
		assertEquals(1.118, resSecant.getRoot(), 0.001);
		assertEquals(2    , resSecant.getSteps());
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.model.NumericMethods#rootNewton(double, double, int, double)}.
	 */
	@Test
	void testRootNewton() {
		assertEquals(1.118, resNewton.getRoot(), 0.001);
		assertEquals(3    , resNewton.getSteps());
		assertEquals(2    , resNewton.getStart());
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.model.NumericMethods#rootIter(double, double, int, double)}.
	 */
	@Test
	void testRootIter() {
		assertEquals(1.118, resIter.getRoot(), 0.001);
		assertEquals(5    , resIter.getSteps());
		assertEquals(1    , resIter.getStart());
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		resBisec = resSecant = resNewton = resIter = null;
	}

}
