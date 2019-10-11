package com.karl.trustarc.ShapesApp;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class SphereTest {
	Sphere sphere = new Sphere(5);
	int value = (int) sphere.area();
	int value1 = (int) sphere.perimeter();

	@Test
	public void testArea() {
		assertThat(314,is(value));
	}

	@Test
	public void testPerimeter() {
		assertThat(523,is(value1));
	}

}
