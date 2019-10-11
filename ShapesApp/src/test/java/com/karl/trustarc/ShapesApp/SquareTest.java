package com.karl.trustarc.ShapesApp;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class SquareTest {
	Square square = new Square(21);

	@Test
	public void testArea() {
		assertThat(441.0,is(square.area()));
	}

	@Test
	public void testPerimeter() {
		assertThat(84.0,is(square.perimeter()));
	}

}
