package com.fiends.service.resource;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fiends.concept.ConceptFrameworkSpace;
import com.fiends.concept.Lexicon;
import com.fiends.service.error.ViolationFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.logging.Logger;


/**
 * @author fwhaslam
 * @since 1.0.0
 */
@Path("/lexicons")
public class LexiconResource {

	static final Logger log = Logger.getLogger(LexiconResource.class.getSimpleName());

	public class GetLexiconKeysResponse {
		public Set<String> keys;
	}

	@JsonPropertyOrder({"key","qualifiers","conceptCount","termCount"})
	public class GetLexiconAttributesResponse {
		public String key;
		public Set<String> qualifiers;
		public int termCount;
		public int conceptCount;
	}

	/**
	 *
	 * @return
	 */
	@GET
	@Path("/version")
	public String getVersion(){return "1.0.0";}

	/**
	 * @return
	 */
	@GET
	@Path("/")
	@Produces( {MediaType.APPLICATION_JSON} )
	public Response getLexiconKeys() throws JsonProcessingException {

		GetLexiconKeysResponse response = new GetLexiconKeysResponse();
		response.keys = ConceptFrameworkSpace.getInstance().getRegistry().keys();

		return Response.ok( response ).build();
	}

	/**
	 * @return
	 */
	@GET
	@Path("/{lexiconKey}")
	@Produces( {MediaType.APPLICATION_JSON} )
	public Response getLexiconAttributes(@PathParam("lexiconKey") String lexiconKey) throws JsonProcessingException {

		Lexicon lexicon = ConceptFrameworkSpace.getInstance().getRegistry().find(lexiconKey);
		if (lexicon==null)
			return ViolationFactory.make( 404, "Lexicon not found ["+lexiconKey+"]",null);

		GetLexiconAttributesResponse response = new GetLexiconAttributesResponse();
		response.key = lexiconKey;
		response.qualifiers = lexicon.getQualifiers();
		response.termCount = lexicon.getTermRegistry().size();
		response.conceptCount = lexicon.getConceptRegistry().size();

		return Response.ok( response ).build();
	}

	/**
	 * @return
	 */
	@GET
	@Path("/{lexiconKey}/qualifiers")
	@Produces( {MediaType.APPLICATION_JSON} )
	public Response getLexiconQualifiers(@PathParam("lexiconKey") String lexiconKey) throws JsonProcessingException {

		Lexicon lexicon = ConceptFrameworkSpace.getInstance().getRegistry().find(lexiconKey);
		if (lexicon==null)
			return ViolationFactory.make( 404, "Lexicon not found ["+lexiconKey+"]",null);

		return Response.ok( lexicon.getQualifiers() ).build();
	}

}
