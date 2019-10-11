package com.karl.trustarc.ShapesApp;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class CircleTest {
	Circle circle = new Circle(5);
	int value = (int) circle.area();
	int value1 = (int) circle.perimeter();
	@Test
	public void testArea() {
		assertThat(78,is(value));
	}

	@Test
	public void testPerimeter() {
		assertThat(31,is(value1));
	}

}
