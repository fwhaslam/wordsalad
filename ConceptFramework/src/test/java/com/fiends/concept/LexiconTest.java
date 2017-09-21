package com.fiends.concept;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class LexiconTest {

	class SampleLexicon extends Lexicon {
		SampleLexicon(){super("SampleLexicon");}
		@Override public boolean initialize(){return true;}
	}

	@Test
	public void constructor_getIdentifier(){

		SampleLexicon lexicon = new SampleLexicon();

		assertSame( lexicon, ConceptFrameworkSpace.getInstance().getLexicon("SampleLexicon"));

		assertEquals("SampleLexicon", lexicon.getIdentifier() );
	}

}
