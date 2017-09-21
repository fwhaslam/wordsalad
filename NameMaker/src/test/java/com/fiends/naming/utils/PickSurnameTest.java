package com.fiends.naming.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author fwhaslam
 * @since 9/11/2017 6:50 PM
 */
public class PickSurnameTest {

	@Test
	public void constructor(){
		PickSurname.get().pickByRatio();   // does not throw NPE
		assertEquals( 3999, PickSurname.get().WHITE_SURNAMES.size() );
	}


	@Test
	public void pickByRatio(){
		for (int ix=0;ix<10;ix++) {
			String name = PickSurname.get().pickByRatio();
			assertNotNull( name );
			assertFalse( name.isEmpty() );
System.out.println("RATIO NAME=" + name);
		}
	}

	@Test
	public void pickRandom() {
System.out.println("total names="+PickSurname.get().WHITE_SURNAMES.size());
		for (int ix=0;ix<10;ix++) {
			String name = PickSurname.get().pickRandom();
			assertNotNull( name );
			assertFalse( name.isEmpty() );
System.out.println("INDEX NAME=" + name);
		}
	}
}
