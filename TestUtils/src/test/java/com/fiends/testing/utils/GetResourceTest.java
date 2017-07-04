package com.fiends.testing.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class GetResourceTest {

	@Test
	public void getString() throws Exception {
		String result = GetResource.getString("testfile.txt");
		assertEquals("hello there.", result );
	}
}
