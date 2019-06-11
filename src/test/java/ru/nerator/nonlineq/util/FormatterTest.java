package ru.nerator.nonlineq.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ru.nerator.nonlineq.model.MyTuple;

/**
 * @author nerator
 *
 */
class FormatterTest {
	
	/**
	 * Test method for {@link ru.nerator.nonlineq.util.Formatter#step(int)}.
	 */
	@Test
	final void testStep() {
		assertEquals("0 шагов", Formatter.step(0));
		assertEquals("1 шаг", Formatter.step(1));
		assertEquals("2 шага", Formatter.step(2));
		assertEquals("3 шага", Formatter.step(3));
		assertEquals("4 шага", Formatter.step(4));
		assertEquals("5 шагов", Formatter.step(5));
		assertEquals("6 шагов", Formatter.step(6));
		assertEquals("7 шагов", Formatter.step(7));
		assertEquals("8 шагов", Formatter.step(8));
		assertEquals("9 шагов", Formatter.step(9));
	}

	/**
	 * Test method for {@link ru.nerator.nonlineq.util.Formatter#formatTuple(ru.nerator.nonlineq.model.MyTuple)}.
	 */
	@Test
	final void testFormatTuple() {
		MyTuple t1 = new MyTuple();
		MyTuple t2 = new MyTuple(1.0,2);
		MyTuple t3 = new MyTuple(3.0,4,5);
		
		assertEquals("Невозможно определить корень.", 
				Formatter.formatTuple(t1));
		assertEquals("Корень равен 1.0, найден за 2 шага", 
				Formatter.formatTuple(t2));
		assertEquals("В качестве начальной точки выбрана точка 5\n" + 
				"Корень равен 3.0, найден за 4 шага", 
				Formatter.formatTuple(t3));		
	}

}
