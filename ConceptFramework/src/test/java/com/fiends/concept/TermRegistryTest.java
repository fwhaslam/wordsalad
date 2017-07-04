package com.fiends.concept;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class TermRegistryTest {

	@Test
	public void constructor_size(){

		TermRegistry registry = new TermRegistry();

		assertEquals(0, registry.size() );
	}

	@Test
	public void fix_new(){

		TermRegistry registry = new TermRegistry();

		// invocation
		Term result = registry.fix( "goblin", null );

		assertEquals(1, registry.size() );
		assertEquals("{goblin={unknown=(unknown)goblin}}", registry.registry.toString() );

		assertEquals("(unknown)goblin", result.toString());
	}

	@Test
	public void fix_copy(){

		TermRegistry registry = new TermRegistry();
		registry.fix( "goblin", "noun" );

		// invocation
		Term result = registry.fix( "goblin", "noun" );

		assertEquals(1, registry.size() );
		assertEquals("{goblin={noun=(noun)goblin}}", registry.registry.toString() );

		assertEquals("(noun)goblin", result.toString());
	}
}
