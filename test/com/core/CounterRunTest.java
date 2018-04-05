package com.core;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.in.WordFactory;

public class CounterRunTest {
	private static Counter wf;
	private static Map<String, Integer> res;

	@BeforeClass
	public static void beforeClass() {
		WordFactory wfa=new WordFactory(new File("run.txt"));
		wf=new WordCounter(wfa);
		res=new HashMap<String,Integer>();
//		abc cda e--- ok abc
		res.put("abc", 2);
		res.put("cda",1);
		res.put("e", 1);
		res.put("ok", 1);
	}
	
	@Test
	public void testRun() {
		wf.run();
		for(Map.Entry<String, Integer>e:wf.mp.entrySet()) {
			assertEquals(e.getValue(),res.get(e.getKey()));
		}
	}

}
