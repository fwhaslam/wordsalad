package com.fiends.concept;

import java.util.HashSet;
import java.util.Set;

/**
 * A word or short phrase, frequently representing a single concept.
 *
 * Qualifier is some grouping of terms.
 *     For example, qualifier might be Parts of Speech ( noun, verb, etc. )
 *     Or it might be a game classification ( Agent, Location, Faction, etc. )
 *     Qualifiers vary depending on lexicion.
 *
 * Qualifiers are used as a hint that two labels may be distinct, or that some labels may have greater similarity.
 *
 * @author fwhaslam
 * @since 1.0.0
 */
public class Term implements Comparable<Term> {

	static final public String DEFAULT_QUALIFIER = "unknown";

	final String qualifier;
	final String label;
	final Set<Concept> conceptSet;

	public Term(String label, String qualifier){
		this.label = label;
		this.qualifier = ( qualifier==null ? DEFAULT_QUALIFIER : qualifier);
		this.conceptSet = new HashSet<>();
	}

	public String getQualifier(){return qualifier;}
	public String getLabel(){return label;}

	void bind(Concept concept){conceptSet.add(concept);}
	public Set<Concept> getConceptSet(){return conceptSet;}

	@Override
	public String toString(){return "("+qualifier +")"+label;}

	@Override
	public int compareTo(Term what){
		return toString().compareTo(what.toString());
	}

}
