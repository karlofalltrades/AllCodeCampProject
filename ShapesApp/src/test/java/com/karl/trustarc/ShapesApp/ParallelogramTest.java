package com.karl.trustarc.ShapesApp;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class ParallelogramTest {
	Parallelogram parallel = new Parallelogram(5,9);

	@Test
	public void testArea() {
		assertThat(45.0,is(parallel.area()));
	}

	@Test
	public void testPerimeter() {
		assertThat(19.0,is(parallel.perimeter()));
	}
	
//	Parallelogram Base: 5.0 Height: 9.0
//	Area: 45.0
//	Perimeter: 19.0

}
