package com.fiends.utils;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class NameUtils {

	/**
	 * Change the casing to a single upper case followed by lower case.
	 *
	 * @param name
	 * @return
	 */
	static public String nameCasing(String name){
		if (name==null || name.length()==0) return name;
		if (name.length()==1) return name.toUpperCase();
		return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
	}
}
