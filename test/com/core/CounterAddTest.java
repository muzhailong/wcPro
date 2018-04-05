package com.core;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class CounterAddTest {
	private static Counter counter;
	private static Map<String, Integer> mp;
	private static String[] s;

	@BeforeClass
	public static void beforeClass() {
		counter = new WordCounter(null);
		mp = new HashMap<String, Integer>();
		s = new String[] { "abc", "efg", "ok", "add-is", "combine", "abc", "ok" };
		for (String st : s) {
			if (mp.containsKey(st)) {
				mp.put(st, mp.get(st) + 1);
			} else {
				mp.put(st, 1);
			}
		}
	}

	@Test
	public void testAdd() {
		for (String st : s) {
			counter.add(st);
		}
		for (Map.Entry<String, Integer> e : counter.mp.entrySet()) {
			assertEquals(e.getValue(), mp.get(e.getKey()));
		}
	}

}
