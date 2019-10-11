package com.karl.trustarc.ShapesApp;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class RectangleTest {
	Rectangle rectangle = new Rectangle(5,2);

	@Test
	public void testArea() {
		assertThat(10.0,is(rectangle.area()));
	}

	@Test
	public void testPerimeter() {
		assertThat(14.0,is(rectangle.perimeter()));
	}

}
