package com.fiends.service.error;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class ViolationFactory {

	static public class Violation {
		public String msg;
		public List<String> tags;
	}

	static public class Violations {
		public ArrayList<Violation> violations;
	}

	static public Response make(int code, String msg, String ... tags) throws JsonProcessingException {
		Violation violation = new Violation();
		violation.msg = msg;
		if (tags!=null && tags.length>0) violation.tags = Arrays.asList(tags);
		Violations violations = new Violations();
		violations.violations = new ArrayList( Arrays.asList( violation ) );

		return Response.status(code).entity( violations ).build();
	}

}
