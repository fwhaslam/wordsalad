package com.fiends.oosyn;

import com.fiends.concept.Concept;
import com.fiends.concept.Lexicon;
import com.fiends.concept.Term;
import junit.framework.AssertionFailedError;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class OpenOfficeSynonymLexiconTest {

	@Test
	public void initialize(){

		Lexicon lexicon = OpenOfficeSynonymLexicon.getInstance();

		lexicon.initialize();
		Term term = lexicon.findTerm("goblin","noun");

		assertNotNull("Could not find term [goblin]",term);
		assertEquals("(noun)goblin",term.toString());

//		for (Concept concept : term.getConceptSet() ) {
//			System.out.println("CONCEPT="+concept.toString());
//		}

		assertEquals( 3, term.getConceptSet().size() );
		List<Concept> concepts = new ArrayList<>(term.getConceptSet());

		assertEquals("=(noun)evil spirit/(noun)goblin/(noun)hob/(noun)hobgoblin",
				concepts.get(0).toString().substring(44));
		assertEquals("=(noun)evil spirit/(noun)goblin/(noun)hob/(noun)hobgoblin",
				concepts.get(1).toString().substring(44));
		assertEquals("=(noun)evil spirit/(noun)goblin/(noun)hob/(noun)hobgoblin",
				concepts.get(2).toString().substring(44));

	}

	/**
	 *
	 * @param klass
	 * @param instance
	 * @param function
	 * @param <T>
	 */
	<T> void assertThrows( Class<? extends Throwable> klass, T instance, Consumer<T> function){
		try {
			function.accept(instance);
			fail("Failed to throw exception");
		}
		catch (AssertionFailedError afex){throw afex;}
		catch( Throwable ex){
			if ( !(klass.isAssignableFrom(ex.getClass())) )
				fail("Unexpected exception type thrown ["+ex.getClass());
		}
	}

	@Test
	public void asQualifier(){

		OpenOfficeSynonymLexicon lexicon = OpenOfficeSynonymLexicon.getInstance();

		assertEquals("noun", lexicon.asQualifier("(noun)") );
		assertThrows( RuntimeException.class, lexicon, lex -> lex.asQualifier("broken") );

	}

}

