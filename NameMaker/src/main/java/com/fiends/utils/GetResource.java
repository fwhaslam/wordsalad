package com.fiends.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class GetResource {

	static public Reader getReader(String path) throws IOException {
		return new InputStreamReader(getStream(path));
	}

	/**
	 *
	 * @param path
	 * @return
	 * @throws IOException
	 */
	static public InputStream getStream(String path) throws IOException {
		return GetResource.class.getClassLoader().getResource( path ).openStream();
	}

	/**
	 *
	 * @param path
	 * @return
	 * @throws IOException
	 */
	static public String getString(String path) throws IOException {
		return IOUtils.toString( getStream(path), Charset.forName("UTF-8") );
	}

}
