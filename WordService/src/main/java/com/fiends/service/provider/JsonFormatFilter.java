package com.fiends.service.provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Singleton;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;

@Singleton
@Provider
public class JsonFormatFilter implements ContainerResponseFilter {

	static final Logger log = Logger.getLogger(JsonResponseResolver.class.getSimpleName());

	final ObjectMapper trimMapper;
	final ObjectMapper prettyMapper;


	public JsonFormatFilter() {

		// trim mapper is default
		trimMapper = new ObjectMapper();
		trimMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		trimMapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
		trimMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		// pretty mapper will indent response
		prettyMapper = new ObjectMapper();
		prettyMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		prettyMapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
		prettyMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		prettyMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	@Override
	public void filter(
			ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {

		// only operate on json responses
		if (!StringUtils.equals(MediaType.APPLICATION_JSON, responseContext.getHeaderString(CONTENT_TYPE))) return;

		// we only parse objects that are not strings
		Object entity = responseContext.getEntity();
		if (entity==null || entity.getClass()==String.class) return;

		boolean isPretty = requestContext.getUriInfo().getQueryParameters().containsKey("pretty");
		responseContext.setEntity( isPretty ?
				prettyMapper.writeValueAsString(entity) :
				trimMapper.writeValueAsString(entity));
	}

}