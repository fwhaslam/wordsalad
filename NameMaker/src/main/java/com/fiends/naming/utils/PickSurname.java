package com.fiends.naming.utils;

import com.fiends.utils.GetResource;
import com.fiends.utils.NameUtils;
import com.fiends.utils.RatioSet;
import com.fiends.utils.Roller;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;


/**
 * @author fwhaslam
 * @since 9/11/2017 6:14 PM
 */
public class PickSurname {

	static final Logger log = Logger.getLogger(PickSurname.class);

	static private PickSurname singleton = new PickSurname().initialize();
	static public PickSurname get(){return singleton;}

	static final String WHITE_SURNAMES_PATH = "WhiteSurnames.csv";

	final RatioSet<String> WHITE_SURNAMES =  new RatioSet<String>();

	PickSurname initialize() {

		Reader reader = null;
		try {

			CSVFormat format = CSVFormat.DEFAULT.withHeader().withCommentMarker('#');
			reader = GetResource.getReader(WHITE_SURNAMES_PATH);
			CSVParser parser = new CSVParser(reader, format);

			for (CSVRecord record : parser ) {

				int count = Integer.parseInt( record.get("Count") );
				String surname = NameUtils.nameCasing( record.get("Surname") );
//System.out.println("SURNAME="+surname);
				WHITE_SURNAMES.add( count, NameUtils.nameCasing(surname) );
			}
			WHITE_SURNAMES.setLocked();

			return this;
		}
		catch (IOException ex){
			log.error("initialize() failed to read.",ex);
			return null;
		}
		finally {
			try {if (reader!=null) reader.close();}
			catch (IOException ex){log.error("initialize() failed to close.",ex);}
		}
	}

	/**
	 * select white surname.
	 * @return
	 */
	public String pickByRatio(){

		long goal = Roller.roll( WHITE_SURNAMES.getBound() );
System.out.println("BOUND="+WHITE_SURNAMES.getBound() +"   RATIO GOAL="+goal);

		return WHITE_SURNAMES.getByRatio( goal );
	}

	/**
	 * select white surname.
	 * @return
	 */
	public String pickRandom(){

//System.out.println("BOUND="+WHITE_SURNAMES.getBound() );
		int index = Roller.roll( WHITE_SURNAMES.size() );
System.out.println("BOUND="+WHITE_SURNAMES.getBound() +"   RANDOM GOAL="+index);

		return WHITE_SURNAMES.getByIndex( index );
	}

}
