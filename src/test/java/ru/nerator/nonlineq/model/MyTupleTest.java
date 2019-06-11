package ru.nerator.nonlineq.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyTupleTest {

	private static MyTuple t1,t2,t3;
		
	@BeforeAll
	static void setUpBeforeClass() {
		t1 = new MyTuple();
		t2 = new MyTuple(1.0, 2);
		t3 = new MyTuple(3.0, 4, 5);
	}

	
	/**
	 * Test method for {@link ru.nerator.nonlineq.model.MyTuple#haveStart()}.
	 */
	@Test
	final void testHaveStart() {
		assertFalse(t1.haveStart());
		assertFalse(t2.haveStart());
		assertTrue (t3.haveStart());
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.model.MyTuple#isEmpty()}.
	 */
	@Test
	final void testIsEmpty() {
		assertTrue (t1.isEmpty());
		assertFalse(t2.isEmpty());
		assertFalse(t3.isEmpty());
	}

	@AfterAll
	static void tearDownAfterClass() {
		t1 = t2 = t3 = null;
	}
	
}
