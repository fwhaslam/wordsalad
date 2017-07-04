package com.fiends.concept;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class ConceptFrameworkSpace {

	static final ConceptFrameworkSpace singleton = new ConceptFrameworkSpace();
	static public ConceptFrameworkSpace getInstance(){return singleton;}

	public LexiconRegistry registry = new LexiconRegistry();

	/**
	 *
	 * @return
	 */
	public LexiconRegistry getRegistry(){return registry;}

	public Lexicon getLexicon(String lexiconKey){return registry.find(lexiconKey);}

}