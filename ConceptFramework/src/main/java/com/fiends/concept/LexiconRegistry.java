package com.fiends.concept;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class LexiconRegistry {

	final Map<String,Lexicon> registry = new ConcurrentHashMap<>();
	/**
	 *
	 * @return
	 */
	public int size(){return registry.size();}

	/**
	 *
	 * @param lexicon
	 * @return
	 */
	public Lexicon register(Lexicon lexicon){
		String lexiconIdentifier = lexicon.getIdentifier();
		if (!registry.containsKey(lexiconIdentifier))
			registry.put( lexiconIdentifier, lexicon );
		return registry.get(lexiconIdentifier);
	}

	/**
	 *
	 * @param lexiconIdentifier
	 * @return
	 */
	public Lexicon find(String lexiconIdentifier){
		return registry.get(lexiconIdentifier);
	}

	/**
	 *
	 * @return
	 */
	public Set<String> keys(){return registry.keySet();}

}
