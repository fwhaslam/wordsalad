package com.fiends.concept;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import static com.fiends.concept.Term.DEFAULT_QUALIFIER;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class TermRegistry {

	final Map<String,Map<String,Term>> registry = new ConcurrentHashMap<>();

	/**
	 *
	 * @return
	 */
	public int size(){return registry.size();}

	/**
	 *
	 * @return
	 */
	public Term fix(String label, String qualifier){

		if (qualifier==null) qualifier = DEFAULT_QUALIFIER;

		// find
		Term found = find(label,qualifier);
		if (found!=null) return found;

		// fix
		if (!registry.containsKey(label))
			registry.put( label, new TreeMap<>() );

		Term make = new Term(label,qualifier);
		registry.get(label).put( make.getQualifier(), make );
		return make;
	}

	/**
	 *
	 * @param label
	 * @return
	 */
	public Map<String,Term> find(String label){
		return registry.get(label);
	}

	/**
	 *
	 * @param label
	 * @param qualifier
	 * @return
	 */
	public Term find(String label, String qualifier){
		Map<String,Term> found = find(label);
		if (found==null) return null;
		if (qualifier==null) qualifier = DEFAULT_QUALIFIER;
		return found.get(qualifier);
	}

}
