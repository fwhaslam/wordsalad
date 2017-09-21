package com.fiends.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author fwhaslam
 * @since 1.0.0
 */
public class RatioSetTest {

	static class Sample {
		int count;
		String value;

		public Sample(int count, String value) {
			this.count = count;
			this.value = value;
		}
	}

	List<Sample> SAMPLES = Arrays.asList(
			new Sample(5, "first"),
			new Sample(1, "second"),
			new Sample(100, "third"),
			new Sample(0, "fourth"),
			new Sample(25, "fifth")
	);

	@Test
	public void constructor() {

		RatioSet<String> result = new RatioSet<>();

		assertEquals(0L, result.getBound());
		assertFalse(result.isLocked());

		result.setLocked();
		assertEquals(0L, result.getBound());
		assertTrue(result.isLocked());

		assertNull(result.getByRatio(0));
		assertNull(result.getByRatio(-1));
		assertNull(result.getByRatio(100));
	}

	@Test
	public void add() {

		RatioSet<String> work = new RatioSet<>();

		for (Sample sample : SAMPLES) work.add(sample.count, sample.value);
		work.setLocked();

		assertEquals(0L, work.index[0]);
		assertEquals(5L, work.index[1]);
		assertEquals(6L, work.index[2]);
		assertEquals(106L, work.index[3]);
//		assertEquals(106L, work.index[4]); // no entry for 'fourth'
		assertEquals(131L, work.getBound());

		assertEquals("[5|0|first, 1|5|second, 100|6|third, 25|106|fifth]",
				work.list.toString());
	}


	@Test
	public void getByRatio() {

		RatioSet<String> work = new RatioSet<>();

		for (Sample sample : SAMPLES) work.add(sample.count, sample.value);
		work.setLocked();

		assertNull( work.getByRatio(-1) );
		assertNull( work.getByRatio(131) );

		assertEquals("first", work.getByRatio(0));
		assertEquals("first", work.getByRatio(3));
		assertEquals("first", work.getByRatio(4));

		assertEquals("second", work.getByRatio(5));

		assertEquals("third", work.getByRatio(6));
		assertEquals("third", work.getByRatio(92));
		assertEquals("third", work.getByRatio(105));

		// fourth is not accessible.
		assertEquals("fifth", work.getByRatio(106));
		assertEquals("fifth", work.getByRatio(107));
		assertEquals("fifth", work.getByRatio(130));
	}

	@Test
	public void getByIndex() {

		RatioSet<String> work = new RatioSet<>();

		for (Sample sample : SAMPLES) work.add(sample.count, sample.value);
		work.setLocked();

		assertNull( work.getByIndex(-1) );
		assertNull( work.getByIndex(5) );

		assertEquals("first", work.getByIndex(0));
		assertEquals("second", work.getByIndex(1));
		assertEquals("third", work.getByIndex(2));
		// fourth is not accessible.
		assertEquals("fifth", work.getByIndex(3));

	}

}
