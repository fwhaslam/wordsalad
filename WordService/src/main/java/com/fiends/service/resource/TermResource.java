package com.fiends.service.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiends.concept.Lexicon;
import com.fiends.concept.Term;
import com.fiends.oosyn.OpenOfficeSynonymLexicon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
@Path("/term")
public class TermResource {

	static final Logger log = Logger.getLogger(TermResource.class.getSimpleName());

	static Lexicon getDictionary(){
		return OpenOfficeSynonymLexicon.getInstance();
	}

	public class TermResponse {
		public String label,qualifier;
		TermResponse(Term term){label=term.getLabel();qualifier=term.getQualifier();}
	}

	public class TermByQualifierResponse {
		public Map<String,TermResponse> termsByQualifier = new TreeMap<>();
		TermByQualifierResponse(Map<String,Term> termMap){
			for (String qualifier : termMap.keySet())
				termsByQualifier.put( qualifier, new TermResponse(termMap.get(qualifier)) );
		}
		TermByQualifierResponse(Term term){termsByQualifier.put(term.getQualifier(),new TermResponse(term));}
	}

//======================================================================================================================

	 /**
	 *
	 * @return
	 */
	@GET
	@Path("/version")
	public String getVersion(){return "1.0.0";}

	/**
	 *
	 * @param label
	 * @return
	 */
	@GET
	@Path("/{label}")
	@Produces( {MediaType.APPLICATION_JSON} )
	public Response getTermByLabel(
			@PathParam("label") String label) throws JsonProcessingException {

		Lexicon lexicon = getDictionary();

		TermByQualifierResponse response = new TermByQualifierResponse(lexicon.findTerm(label));

		return Response.ok( response ).build();
	}

	/**
	 *
	 * @param label
	 * @param qualifier
	 * @return
	 */
	@GET
	@Path("/{label}/{qualifier}")
	@Produces( {MediaType.APPLICATION_JSON} )
	public Response getTermByLabelQualifier(
			@PathParam("label") String label,
			@PathParam("qualifier") String qualifier) throws JsonProcessingException {

		Lexicon lexicon = getDictionary();

		TermByQualifierResponse response = new TermByQualifierResponse(lexicon.findTerm(label,qualifier));

		return Response.ok( response ).build();
	}

}
