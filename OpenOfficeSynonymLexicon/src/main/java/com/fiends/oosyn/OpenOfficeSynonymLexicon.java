package com.fiends.oosyn;

import com.fiends.concept.Concept;
import com.fiends.concept.Lexicon;
import com.fiends.concept.Term;
import com.fiends.tools.GetResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Synonym Lexicon.  The qualifiers are simplified Parts of Speech:  (noun), (adj), etc.
 * @author fwhaslam
 * @since 1.0.0
 */
public class OpenOfficeSynonymLexicon extends Lexicon {

	static final OpenOfficeSynonymLexicon singleton = new OpenOfficeSynonymLexicon();
	synchronized static public OpenOfficeSynonymLexicon getInstance(){return singleton;}

	OpenOfficeSynonymLexicon(){
		super("OOSL");
	}

	/**
	 * Load from resources.
	 */
	synchronized public boolean initialize()  {

		System.out.println("INITIALIZING OOSL Lexicon");

		try {

			BufferedReader input = GetResource.getReader("thesaurus/th_en_US_new.dat");

			// skip first line which explains format
			String line = input.readLine();

			// 0 indicates we are about to read a new 'concept'
			int expect = 0;
			String label = null;
//			String qualifier = null;
//			Concept concept = null;

			while (true) {

				line = input.readLine();
				if (line==null) break;

				try {
					String[] tokens = line.split("\\|");

					// parse new concept line
					if (expect == 0) {
						if (tokens.length > 2)
							throw new RuntimeException("Unparsable Concept Line = [" + line + "]  tokens="+ Arrays.asList(tokens));
						label = tokens[0];
						expect = Integer.parseInt(tokens[1]);
					}
					// parse synonym line
					else {
						parseSynonymLine( label, tokens );
						// countdown synonym lines
						expect--;
					}
				}
				catch(Exception ex){
					throw new IOException("Failed to parse ["+line+"] expect="+expect, ex );
				}
			}

			return true;
		}
		catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
		finally {
			System.out.println("INITIALIZING OOSL Lexicon -- COMPELETE");
		}
	}

	/**
	 *
	 * @param label
	 * @param tokens
	 */
	void parseSynonymLine(String label, String[] tokens){

		String qualifier = asQualifier(tokens[0]);
//if ("goblin".equals(label))
//	System.out.println("BUILDING "+qualifier+"/goblin");

		// create concept, bind label as first term
		Concept concept = createConcept();
		Term term = fixTerm( label, qualifier );
		bind(concept, term);

		// bind followup labels to concept
		for (int ix = 1; ix < tokens.length; ix++) {
			term = fixTerm( tokens[ix], qualifier );
			bind(concept, term);
		}
	}

	/**
	 *
	 * @return
	 */
	String asQualifier(String value) {
		if (!value.startsWith("(") || !value.endsWith(")"))
			throw new RuntimeException("Unexpected qualifier (missing parenthesis) ["+value+"]");
		return value.substring(1,value.length()-1);
	}

}

