package com.fiends.concept;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * A lexicon is a collection of concepts, labels ( words ), and relations.  It is similar to
 *
 * Lexicon identifier.  Each dictionary used by the project will have a distinct identifier.
 *
 * @author fwhaslam
 * @since 1.0.0
 */
abstract public class Lexicon implements Identifiable {

	String identifier;

	Set<String> qualifiers;
	ConceptRegistry conceptRegistry;
	TermRegistry termRegistry;

	protected Lexicon(String identifier){
		this.identifier = identifier;
		qualifiers = new TreeSet<>();
		conceptRegistry = new ConceptRegistry();
		termRegistry = new TermRegistry();
		ConceptFrameworkSpace.getInstance().getRegistry().register(this);
	}

	/**
	 * Returns true for successful load.  False for any type of failure.
	 * @return
	 */
	abstract public boolean initialize();

	public String getIdentifier(){return identifier;}

	public Set<String> getQualifiers(){return qualifiers;}

	public ConceptRegistry getConceptRegistry(){return conceptRegistry;}

	public TermRegistry getTermRegistry(){return termRegistry;}

//======================================================================================================================

	public Concept createConcept(){return conceptRegistry.create();}

	public Concept findConcept(String identifier){return conceptRegistry.find(identifier);}

	public Term fixTerm( String label, String qualifier ){
		qualifiers.add( qualifier );
		return termRegistry.fix(label,qualifier);
	}

	public Map<String,Term> findTerm(String label){return termRegistry.find(label);}

	public Term findTerm(String label, String qualifier){return termRegistry.find(label,qualifier);}

	public void bind(Concept concept,Term term){
		term.bind(concept);
		concept.bind(term);
	}

}
