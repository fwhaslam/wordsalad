package com.fiends.concept;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class ConceptTest {

	@Test
	public void constructor_toString(){

		Set<Term> termSet = new HashSet();
		termSet.add( new Term("rat","noun"));
		termSet.add( new Term("hairy","adj"));

		Concept concept = new Concept( termSet );

		assertEquals("(adj)hairy:(noun)rat", concept.toString() );
		assertEquals("2314c079b0a3a014a16012b508dd1e1f", concept.getIdentifier() );

	}

}
