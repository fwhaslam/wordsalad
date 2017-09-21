package com.fiends.concept;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Set;
import java.util.TreeSet;

/**
 * Representation of a concept.  Terms have to be associated via some lexicon,
 *      ALTHOUGH we should be able to use Label/Synonyms to link similar concepts.
 *
 * @author fwhaslam
 * @since 1.0.0
 */
public class Concept implements Identifiable, Comparable<Concept> {

	String identifier;
	String keyString;
	Set<Term> termSet;

	/**
	 * Package accessible, must be created by ConceptRegistry.
	 * @param unorderedTermSet
	 */
	Concept(Set<Term> unorderedTermSet){
		this.termSet = new TreeSet<>(unorderedTermSet);
		keyString = asStringKey( this.termSet );
		identifier = DigestUtils.md5Hex( keyString );
	}

	public String getIdentifier(){return identifier;}

	void bind(Term term){termSet.add(term);}
	public Set<Term> getTermSet(){return termSet;}

	/**
	 *
	 * @return
	 */
	@Override
	public String toString(){return keyString; }

	/**
	 * Distinct key set.  Identical concepts will match 100%.
	 * @param termSet
	 * @return
	 */
	String asStringKey(Set<Term> termSet){return StringUtils.join( termSet, ":"); }

	@Override
	public int compareTo(Concept what){
		return identifier.compareTo(what.identifier);
	}

}
