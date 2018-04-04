package com.in;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class NextTest {
	private static WordFactory wf;
	private int len;
	
	@Before
	public void before() {
		File f = new File("1.txt");
		wf = new WordFactory(f);
	}
	@Test
	public void testNext1() {

	}

}
