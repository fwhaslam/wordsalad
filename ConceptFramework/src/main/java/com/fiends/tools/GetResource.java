package com.fiends.tools;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class GetResource {

	/**
	 *
	 * @param path
	 * @return
	 * @throws IOException
	 */
	static public String getString(String path) throws IOException {
		return IOUtils.toString( getStream(path), CharEncoding.UTF_8 );
	}

	/**
	 *
	 * @param path
	 * @return
	 * @throws IOException
	 */
	static public BufferedReader getReader(String path) throws IOException {
		return new BufferedReader( new InputStreamReader( getStream(path), CharEncoding.UTF_8) );
	}

	/**
	 *
	 * @param path
	 * @return
	 * @throws IOException
	 */
	static public InputStream getStream(String path) throws IOException {
		URL url = GetResource.class.getClassLoader().getResource(path);
		return url.openStream();
	}

}
