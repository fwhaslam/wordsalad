package com.fiends.resource.resource;

import com.fiends.testing.utils.ServiceRunner;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static com.fiends.testing.utils.ServiceRunner.asString;
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
		String responseBody = asString(response);
		assertEquals(200, response.getStatus());
		assertEquals("1.0.0",responseBody);
	}

	@Test
	public void getSynonymByLabelQualfier() throws Exception {

		Client client = ClientBuilder.newClient();

		// Valid URIs
		Response response = client.target("http://localhost:8282/synonym/poleax/noun?pretty").request().get();

		// assertions
		String responseBody = asString(response);
		assertEquals(200, response.getStatus());
		assertEquals("{\n" +
				"  \"label\" : \"poleax\",\n" +
				"  \"qualifier\" : \"noun\",\n" +
				"  \"concepts\" : [ {\n" +
				"    \"identifier\" : \"a91a3985-efc8-47cd-b250-72cff3b9af2a\",\n" +
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
				"  }, {\n" +
				"    \"identifier\" : \"051de287-89bb-4be6-888c-3f54315fb18b\",\n" +
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
				"    \"identifier\" : \"218c25c4-60f1-45a4-99cb-92a9673d6e96\",\n" +
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
				"    \"identifier\" : \"46457e33-990e-4eac-8a2a-dd796fe10190\",\n" +
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
