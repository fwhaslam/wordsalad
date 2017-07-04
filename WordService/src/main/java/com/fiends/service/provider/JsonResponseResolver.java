package com.fiends.service.provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration for producing JSON Responses.
 */
//@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonResponseResolver implements ContextResolver<ObjectMapper> {

    static final Logger log = Logger.getLogger( JsonResponseResolver.class.getSimpleName() );

    final ObjectMapper trimMapper;
    final ObjectMapper prettyMapper;

    @Context UriInfo uriInfo;

    public JsonResponseResolver() {

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

    @Override public ObjectMapper getContext(Class<?> type) {
        try {
            if(uriInfo.getQueryParameters().containsKey("pretty")) return prettyMapper;
        }
        catch(Exception ex) {
            log.log(Level.SEVERE, "Failed to access query parameters for 'pretty' param", ex);
        }
        return trimMapper;
    }

}
