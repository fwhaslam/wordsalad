package com.fiends.resource.resource;

import com.fiends.testing.utils.ServiceRunner;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static com.fiends.testing.utils.ServiceRunner.asUniformString;
import static org.junit.Assert.assertEquals;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class LexiconResourceIntegrationTest {

	@BeforeClass
	static public void beforeClass() throws IOException {

		ServiceRunner.launch();

	}

	@Test
	public void getVersion() throws Exception {

		Client client = ClientBuilder.newClient();

		// invocation.
		Response response = client.target("http://localhost:8282/synonym/version?pretty").request().get();

		// assertions
		String responseBody = asUniformString(response);
		assertEquals(200, response.getStatus());
		assertEquals("1.0.0",responseBody);
	}

	@Test
	public void getSynonymByLabelQualfier() throws Exception {

		Client client = ClientBuilder.newClient();

		// Valid URIs
		Response response = client.target("http://localhost:8282/synonym/poleax/noun?pretty").request().get();

		// assertions
		String responseBody = asUniformString(response);
		assertEquals(200, response.getStatus());
		assertEquals("{\n" +
				"  \"label\" : \"poleax\",\n" +
				"  \"qualifier\" : \"noun\",\n" +
				"  \"concepts\" : [ {\n" +
				"    \"identifier\" : \"a32095c08e5f666cc1a9c342a1d8581f\",\n" +
				"    \"terms\" : [ {\n" +
				"      \"label\" : \"ax\",\n" +
				"      \"qualifier\" : \"noun\"\n" +
				"    }, {\n" +
				"      \"label\" : \"axe\",\n" +
				"      \"qualifier\" : \"noun\"\n" +
				"    }, {\n" +
				"      \"label\" : \"poleax\",\n" +
				"      \"qualifier\" : \"noun\"\n" +
				"    }, {\n" +
				"      \"label\" : \"poleaxe\",\n" +
				"      \"qualifier\" : \"noun\"\n" +
				"    } ]\n" +
				"  }, {\n" +
				"    \"identifier\" : \"b910d9cdab1323b1ddcb877b3e446c82\",\n" +
				"    \"terms\" : [ {\n" +
				"      \"label\" : \"battle-ax\",\n" +
				"      \"qualifier\" : \"noun\"\n" +
				"    }, {\n" +
				"      \"label\" : \"battle-axe\",\n" +
				"      \"qualifier\" : \"noun\"\n" +
				"    }, {\n" +
				"      \"label\" : \"poleax\",\n" +
				"      \"qualifier\" : \"noun\"\n" +
				"    }, {\n" +
				"      \"label\" : \"poleaxe\",\n" +
				"      \"qualifier\" : \"noun\"\n" +
				"    } ]\n" +
				"  } ]\n" +
				"}", responseBody );
	}

}
