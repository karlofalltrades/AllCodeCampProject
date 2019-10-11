package com.karl.trustarc.beehive;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Driver.class)
public class DriverTest {
	
	private Driver driver;
	
	@Before
	public void init() {
		PowerMockito.mockStatic(Driver.class);
		driver = new Driver();
	}

	@Test
	public void testGetCoordinates() {
		driver = mock(Driver.class);
		Coordinates c = new Coordinates(1,2);
		ArrayList<Coordinates> temp = new ArrayList<>();
		temp.add(c);
		List<Coordinates> list  = new ArrayList<>();
		list = driver.getCoordinates(temp, c); 
		when(driver.getCoordinates(temp, c)).thenReturn(temp);
		Coordinates coord = new Coordinates(temp.get(0).getX(),temp.get(0).getY());
		assertThat(c.getX(),is(coord.getX()));
		assertThat(c.getY(),is(coord.getY()));
	}

}
