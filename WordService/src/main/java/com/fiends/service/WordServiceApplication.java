package com.fiends.service;

import com.fiends.oosyn.OpenOfficeSynonymLexicon;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Application;
import java.util.logging.Logger;

/**
 * This is used by the web.xml, resources are located automatically.
 * @author fwhaslam
 * @since 1.0.0
 */
public class WordServiceApplication extends Application {

	static final Logger log = Logger.getLogger(WordServiceApplication.class.getSimpleName());

	@PostConstruct
	public void postConstruct(){

		log.info("POST CONSTRUCT");
		OpenOfficeSynonymLexicon.getInstance().initialize();
	}

}
