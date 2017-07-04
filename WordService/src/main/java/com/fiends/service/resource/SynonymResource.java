package com.fiends.service.resource;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiends.concept.Concept;
import com.fiends.concept.Lexicon;
import com.fiends.concept.Term;
import com.fiends.oosyn.OpenOfficeSynonymLexicon;
import com.fiends.service.error.ViolationFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
@Path("/synonym")
public class SynonymResource {

	static final Logger log = Logger.getLogger(SynonymResource.class.getSimpleName());

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

	public class ConceptResponse {
		public String identifier;
		public List<TermResponse> terms = new ArrayList<>();
		ConceptResponse(Concept concept){
			identifier = concept.getIdentifier();
			for (Term term : concept.getTermSet()) terms.add( new TermResponse(term) );
		}
	}

	@JsonPropertyOrder({"label","qualifier","concepts"})
	public class SynonymResponse extends TermResponse {
		public List<ConceptResponse> concepts = new ArrayList<>();
		SynonymResponse(Term term){
			super(term);
			if (term!=null) for (Concept concept : term.getConceptSet() ) concepts.add( new ConceptResponse(concept) );
		}
	}

//======================================================================================================================

	 /**
	 *
	 * @return
	 */
	@GET
	@Path("/version")
	public String getVersion(){return "1.0.0";}

//	/**
//	 *
//	 * @param label
//	 * @return
//	 */
//	@GET
//	@Path("/{label}")
//	@Produces( {MediaType.APPLICATION_JSON} )
//	public Response getSynonymByLabel(
//			@PathParam("label") String label) throws JsonProcessingException {
//
//		Lexicon lexicon = getDictionary();
//
//		SynonymResponse response = new TermByQualifierResponse(lexicon.findTerm(label));
//
//		return Response.ok( response ).build();
//	}

	/**
	 *
	 * @param label
	 * @param qualifier
	 * @return
	 */
	@GET
	@Path("/{label}/{qualifier}")
	@Produces( {MediaType.APPLICATION_JSON} )
	public Response getSynonymByLabelQualfifier(
			@PathParam("label") String label,
			@PathParam("qualifier") String qualifier) throws JsonProcessingException {

		Lexicon lexicon = getDictionary();

		Term term = lexicon.findTerm(label,qualifier);
		if (term==null)
			return ViolationFactory.make(404,"Term not found ["+label+"/"+qualifier+"]");

		SynonymResponse response = new SynonymResponse(lexicon.findTerm(label,qualifier));

		return Response.ok( response ).build();
	}

}
