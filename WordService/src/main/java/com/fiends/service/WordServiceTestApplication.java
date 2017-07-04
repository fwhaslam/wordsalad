package com.fiends.service;

import com.fiends.oosyn.OpenOfficeSynonymLexicon;
import com.fiends.service.provider.JsonFormatFilter;
import com.fiends.service.provider.JsonResponseResolver;
import com.fiends.service.resource.LexiconResource;
import com.fiends.service.resource.SynonymResource;
import com.fiends.service.resource.TermResource;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * This is used with the Testing code, ServiceRunner.  It list the resources in detail.
 * @author fwhaslam
 * @since 1.0.0
 */
public class WordServiceTestApplication extends WordServiceApplication {

	static final Logger log = Logger.getLogger(WordServiceTestApplication.class.getSimpleName());

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> classes = new HashSet<>();

		// resources
		classes.add( LexiconResource.class );
		classes.add( SynonymResource.class );
		classes.add( TermResource.class );

		// providers
		classes.add(JsonFormatFilter.class);
		classes.add(JsonResponseResolver.class);

		return classes;
	}

}
