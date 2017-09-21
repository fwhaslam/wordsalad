package com.fiends.concept;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class ConceptRegistry {

	final Map<String,Concept> registry = new ConcurrentHashMap<>();

	/**
	 *
	 * @return
	 */
	public int size(){return registry.size();}

	/**
	 *
	 * @return
	 */
	public Concept fix(Set<Term> termSet){
		Concept concept =  new Concept(termSet);
		String identifier = concept.getIdentifier();
//boolean isGoblin = (concept.toString().contains("goblin"));
//if (isGoblin) System.out.println("IDENTIFIER="+identifier+"    "+concept );

		// already exists
		if ( registry.containsKey( identifier ) ) {
//if (isGoblin) System.out.println("DUPLICATE returning "+registry.get(identifier)+" instead");
			return registry.get(identifier);
		}
		// new concept, bind to terms
		else {
			registry.put(identifier, concept);
			for (Term term : termSet) term.bind(concept);
//if (isGoblin) System.out.println("ORIGINAL returning "+concept);
			return concept;
		}
	}

	/**
	 *
	 * @param conceptIdentifier
	 * @return
	 */
	public Concept find(String conceptIdentifier){
		return registry.get(conceptIdentifier);
	}

}
