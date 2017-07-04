package com.fiends.concept;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class ConceptTest {

	@Test
	public void constructor_toString(){
		Concept concept = new Concept("some-identifier");

		concept.bind( new Term("rat","noun"));
		concept.bind( new Term("hairy","adj"));

		assertEquals("Concept@some-identifier=(adj)hairy/(noun)rat", concept.toString() );
	}

}
