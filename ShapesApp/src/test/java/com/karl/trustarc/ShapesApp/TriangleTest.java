package com.karl.trustarc.ShapesApp;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class TriangleTest {
	
	@BeforeClass
	public void testTriangle() {
		Triangle triangle = new Triangle(5,7,2);
	}
	
	@Test
	public void testArea() {
		Triangle triangle = new Triangle(5,7,2);
		assertThat(17.5,is(triangle.area()));
	}

	@Test
	public void testPerimeter() {
		Triangle triangle = new Triangle(5,7,2);
		assertThat(14.0,is(triangle.perimeter()));
	}

}
