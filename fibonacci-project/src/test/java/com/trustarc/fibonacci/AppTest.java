package com.trustarc.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.powermock.api.mockito.PowerMockito.*;

import org.hamcrest.core.IsNot;
/**
 * Unit test for simple App.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PowerMockRunner.class)
public class AppTest{
	private App app;
	
	@Before
	public void init() {
		app = mock(App.class);
	}
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	@Test
	public void printFibonacciTest() {
		App app = mock(App.class);
		int n1 =0, n2=1;
		app.printFibonacci(10-2);
		Mockito.verify(app).printFibonacci(10-2);
		assertTrue(app.printFibonacci(10-2));
	}
}
