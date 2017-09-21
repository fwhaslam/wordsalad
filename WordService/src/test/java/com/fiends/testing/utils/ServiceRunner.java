package com.fiends.testing.utils;

import com.fiends.service.WordServiceApplication;
import com.fiends.service.WordServiceTestApplication;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

/**
 * @author fwhaslam
 * @since 7/3/2017 4:02 PM
 */
public class ServiceRunner {

	static final int RUNNER_PORT = 8282;

	static class TestWebService {
		URI uri = null;
		HttpServer server;
		HttpHandler handler;
		Application application;

		void stop(){this.server.stop(0);}

		boolean isStarted(){return (uri!=null);}

		void start(Application application) throws IOException {
			this.uri = UriBuilder.fromUri("http://localhost/").port(RUNNER_PORT).build();
			this.server = HttpServer.create(new InetSocketAddress(uri.getPort()), 0);
			this.application = application;
			this.handler = RuntimeDelegate.getInstance().createEndpoint(application, HttpHandler.class);
			this.server.createContext(uri.getPath(), handler);
			this.server.start();
		}

	}

	static TestWebService service = new TestWebService();

	/**
	 * Cleanup, shutdown service
	 */
	static public void shutdown(){
		service.stop();
	}

	/**
	 * Initialize the application data sources.
	 */
	static public void initialize(){
		((WordServiceApplication)service.application).postConstruct();
	}

	/**
	 * Startup, build memory based service instance.
	 */
	static public void launch() throws IOException {

		synchronized(service) {

			if (service.isStarted()) return;

			service.start( new WordServiceTestApplication() );

			// we want to initialize the service on every launch
			initialize();

			// stop service when tests are completed
			Runtime.getRuntime().addShutdownHook(new Thread() { public void run() { shutdown(); } });

		}

	}

	/**
	 * Utility for reading response bodies; normalized to display MAC + WIN responses the same.
	 * @param response
	 * @return
	 * @throws IOException
	 */
	static public String asUniformString(Response response) throws IOException {
		String body = IOUtils.toString((InputStream)response.getEntity(), Charset.forName("UTF-8"));
		return  body.replaceAll("\r","");
	}

}
