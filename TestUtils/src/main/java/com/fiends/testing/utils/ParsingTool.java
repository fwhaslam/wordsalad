package com.fiends.testing.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

/**
 *
 * @author fwhaslam
 * @since 1.0.0
 */
public class ParsingTool {

	static final ObjectMapper trimMapper =  new ObjectMapper().
			disable(SerializationFeature.FAIL_ON_EMPTY_BEANS).
			enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY).
			setSerializationInclusion(JsonInclude.Include.NON_NULL);

	static final PrettyPrinter prettyPrinter = new DefaultPrettyPrinter(){{
		Indenter indenter = new DefaultIndenter("    ","\n");
		indentObjectsWith(indenter);
		indentArraysWith(indenter);
	}}.withoutSpacesInObjectEntries();

	static final ObjectMapper prettyMapper = new ObjectMapper().
			disable(SerializationFeature.FAIL_ON_EMPTY_BEANS).
			enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY).
			setSerializationInclusion(JsonInclude.Include.NON_NULL).
			enable(SerializationFeature.INDENT_OUTPUT);

	static final ObjectWriter prettyWriter = prettyMapper.writer( prettyPrinter );

	/**
	 *
	 * @param value
	 * @return
	 * @throws IOException
	 */
	static public String toTrimJson(Object value) throws IOException {

		if ( value instanceof String ) value = trimMapper.readTree( (String)value );
		return trimMapper.writeValueAsString(value);
	}

	/**
	 *
	 * @param value
	 * @return
	 * @throws IOException
	 */
	static public String toPrettyJson(Object value) throws IOException {

		if ( value instanceof String ) value = prettyMapper.readTree( (String)value );
		return prettyWriter.writeValueAsString(value);
	}
}
