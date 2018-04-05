package com.core;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.BeforeClass;
import org.junit.Test;

import com.in.WordFactory;

public class CounterSortTest {

	private static Counter wc;
	private static List<String> resKey;
	private static List<Integer> resVal;

	@BeforeClass
	public static void beforeClass() {
		WordFactory wf = new WordFactory(new File("run.txt"));
		wc = new WordCounter(wf);
		resKey=new ArrayList<String>();
		resVal=new ArrayList<Integer>();
		// abc cda e--- ok abc
		resKey.add("abc");
		resVal.add(2);

		resKey.add("ok");
		resVal.add(1);

		resKey.add("e");
		resVal.add(1);

		resKey.add("cda");
		resVal.add(1);

	}

	@Test
	public void testSort() {
		wc.run();
		List<Entry<String, Integer>> lt = wc.get();
		int i=0;
		for (Entry<String, Integer> e : lt) {
				assertEquals(e.getKey(),resKey.get(i));
				assertEquals(e.getValue(),resVal.get(i++));
		}
	}

}
