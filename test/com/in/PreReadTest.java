package com.in;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

/**
 * @author oldBook
 *测试preRead方法
 */
public class PreReadTest {
	private static String res="abc cda e--- ok abc";
	@Test
	public void testPreTest1() {
		File f = new File("run.txt");
		WordFactory wf = new WordFactory(f);
			assertEquals(res,wf.getSb().toString());
	}

}
