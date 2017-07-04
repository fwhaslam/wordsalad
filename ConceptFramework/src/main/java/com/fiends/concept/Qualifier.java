package com.fiends.concept;

import java.util.Comparator;

/**
 * Strongly typed String wrapper to ensure we don't confuse label + qualifier fields.
 *
 * @author fwhaslam
 * @since 1.0.0
 */
public class Qualifier implements Comparable<Qualifier> {

	static final public Qualifier DEFAULT_QUALIFIER = new Qualifier("unknown");

	String value;

	public Qualifier(String value){this.value=value;}

	@Override
	public String toString(){return value;}

	@Override
	public int hashCode(){return value.hashCode();}

	@Override
	public boolean equals(Object what){
		if (what==null) return false;
		if (!(what instanceof Qualifier)) return false;
		return value.equals(((Qualifier)what).value);
	}

	@Override
	public int compareTo(Qualifier what){
		return value.compareTo(what.value);
	}

}
