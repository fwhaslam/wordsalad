package com.fiends.concept;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Representation of a concept.  Labels would have to be associated to via some lexicon,
 *      ALTHOUGH we should be able to use Label/Synonyms to link similar concepts.
 *
 * @author fwhaslam
 * @since 1.0.0
 */
public class Concept implements Identifiable {

	String identifier;
	Set<Term> termSet;

	Concept(String identifier){
		this.identifier = identifier;
		this.termSet = new TreeSet<>();
	}

	public String getIdentifier(){return identifier;}

	void bind(Term term){termSet.add(term);}
	public Set<Term> getTermSet(){return termSet;}

	@Override
	public String toString(){
		List<String> terms = new ArrayList<>();
		for ( Term term : termSet ) terms.add( term.toString() );
		return "Concept@"+identifier+"="+StringUtils.join( terms, "/");
//		StringBuilder builder = new StringBuilder().append("Concept@").append(identifier);
//		for (Term term : termSet ) builder.append( term.toString() ).append(":");
//		return builder.substring(0,builder.length()-1).toString();
	}

}
