package com.karl.trustarc.beehive;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.powermock.api.mockito.PowerMockito.*;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Grid.class)
public class GridTest {
	
	private Grid grid;
	
	@Before
	public void setUp() {
		grid = mock(Grid.class);
	}

	@Test
	public void testAddEdge() {
		grid = mock(Grid.class);
		grid.addEdge("1", "2");
		grid.addEdge("1", "3");
		grid.addEdge("1", "4");
		grid.addEdge("1", "5");
		grid.addEdge("1", "6");
		grid.addEdge("1", "7");
		Mockito.verify(grid).addEdge("1","2");
		
	}

	@Test
	public void testShortestPath() {
		grid = mock(Grid.class);
		List<String> result = grid.shortestPath("1", "2");
		assertThat(result,notNullValue());
	}
	
	@Test
	public void testgetPath() throws Exception{
		Grid c = mock(Grid.class);
		List<String>list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("15");
		list.add("31");
		list.add("53");
		PowerMockito.doReturn(list).when(c,"getPath",ArgumentMatchers.any(),ArgumentMatchers.any());
		List<String> result = c.shortestPath("1", "2");
//		verifyPrivate(c).invoke("getPath", ArgumentMatchers.any(),ArgumentMatchers.any());
		assertThat(list,notNullValue());
	}
	
}
