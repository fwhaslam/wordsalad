package com.fiends.concept;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class PartOfSpeechEnumTest {

	@Test
	public void fromKey() {

		assertNull(PartOfSpeechEnum.fromKey(null));

		assertEquals(PartOfSpeechEnum.NounCommon, PartOfSpeechEnum.fromKey("NN"));
	}

	@Test(expected = RuntimeException.class)
	public void fromKey_invalid(){
		PartOfSpeechEnum.fromKey("invalid");
	}
}
