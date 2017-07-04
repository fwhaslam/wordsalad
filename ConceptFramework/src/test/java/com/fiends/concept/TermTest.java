package com.fiends.concept;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class TermTest {

	@Test
	public void constructor_toString(){
		Term term = new Term("rat","noun");

		assertEquals("(noun)rat", term.toString() );
	}
}
