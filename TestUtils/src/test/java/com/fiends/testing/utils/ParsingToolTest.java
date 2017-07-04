package com.fiends.testing.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class ParsingToolTest {

	@Test
	public void toTrimJson() throws Exception {

		String[] tags = {"A","B"};
		TinyBean source = new TinyBean();
		source.setCount(100);
		source.setName("name");
		source.setUseful(true);
		source.setTags(tags);

		// invocation
		String result = ParsingTool.toTrimJson(source);

		// assertions
		assertEquals("{\"count\":100,\"name\":\"name\",\"tags\":[\"A\",\"B\"],\"useful\":true}", result);
	}

	@Test
	public void toTrimJson_fromString() throws Exception {

		String source = "{\n" +
				"    \"count\":100,\n" +
				"    \"name\":\"name\",\n" +
				"    \"tags\":[\n" +
				"        \"A\",\n" +
				"        \"B\"\n" +
				"    ],\n" +
				"    \"useful\":true\n" +
				"}";

		// invocation
		String result = ParsingTool.toTrimJson(source);

		// assertions
		assertEquals("{\"count\":100,\"name\":\"name\",\"tags\":[\"A\",\"B\"],\"useful\":true}", result);
	}

	@Test
	public void toPrettyJson() throws Exception {

		String[] tags = {"A","B"};
		TinyBean source = new TinyBean();
		source.setCount(100);
		source.setName("name");
		source.setUseful(true);
		source.setTags(tags);


		// invocation
		String result = ParsingTool.toPrettyJson(source);

		// assertions
		assertEquals("{\n" +
				"    \"count\":100,\n" +
				"    \"name\":\"name\",\n" +
				"    \"tags\":[\n" +
				"        \"A\",\n" +
				"        \"B\"\n" +
				"    ],\n" +
				"    \"useful\":true\n" +
				"}", result);
	}


	@Test
	public void toPrettyJson_fromString() throws Exception {

		String source = "{\"count\":100,\"name\":\"name\",\"tags\":[\"A\",\"B\"],\"useful\":true}";

		// invocation
		String result = ParsingTool.toPrettyJson(source);

		// assertions
		assertEquals("{\n" +
				"    \"count\":100,\n" +
				"    \"name\":\"name\",\n" +
				"    \"tags\":[\n" +
				"        \"A\",\n" +
				"        \"B\"\n" +
				"    ],\n" +
				"    \"useful\":true\n" +
				"}", result);
	}

}
