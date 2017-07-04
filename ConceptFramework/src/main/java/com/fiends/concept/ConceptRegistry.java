package com.fiends.concept;

import java.util.Map;
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
	public Concept create(){

		String conceptIdentifier = UUID.randomUUID().toString();
		while (registry.containsKey(conceptIdentifier)) conceptIdentifier = UUID.randomUUID().toString();

		registry.put( conceptIdentifier, new Concept(conceptIdentifier) );
		return registry.get(conceptIdentifier);
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
