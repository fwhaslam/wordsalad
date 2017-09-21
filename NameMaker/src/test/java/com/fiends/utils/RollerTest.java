package com.fiends.utils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class RollerTest {

	@Test
	public void constructor(){
		Roller.roll(10);   // does not throw NPE
	}

	@Test
	public void roll(){
		for (int ix=0;ix<100;ix++) {
			int result = Roller.roll(10);
			assertTrue(result >= 0 && result < 10);
		}
	}
}
