package com.fiends.utils;

import java.security.SecureRandom;

/**
 * @author fwhaslam
 * @since 9/11/2017 6:41 PM
 */
public class Roller {

	static final SecureRandom DICE = new SecureRandom();

	/**
	 *
	 * @param bound
	 * @return int number in range [ 0, bound )
	 */
	static public int roll( int bound ) {return DICE.nextInt(bound);}

	/**
	 *
	 * @param bound
	 * @return long number in range [ 0, bound )
	 */
	static public long roll( long bound ) {return ( DICE.nextLong()&0x7fffffffffffffffL %bound);}

}
