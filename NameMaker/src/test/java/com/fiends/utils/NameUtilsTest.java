package com.fiends.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class NameUtilsTest {

	@Test
	public void nameCasing(){

		assertNull( NameUtils.nameCasing(null) );
		assertEquals( "", NameUtils.nameCasing("") );
		assertEquals( "Z", NameUtils.nameCasing("z") );
		assertEquals( "Z", NameUtils.nameCasing("Z") );

		assertEquals("Bob",NameUtils.nameCasing("boB"));
		assertEquals("Bob",NameUtils.nameCasing("Bob"));
		assertEquals("Bob",NameUtils.nameCasing("BoB"));
		assertEquals("Bob",NameUtils.nameCasing("bOb"));
		assertEquals("Bob",NameUtils.nameCasing("bOB"));
		assertEquals("Bob",NameUtils.nameCasing("BOB"));

		assertEquals("Aquifer",NameUtils.nameCasing("aquiFER"));
	}
}
