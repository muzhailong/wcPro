package com.in;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;


//等价类划分 边界测试
/**
 * @author oldBook
 *测试next方法
 */
public class NextTest {
	private static WordFactory wf;
	private static String[] res;

	@BeforeClass
	public static void before() {
		File f = new File("next.txt");
		wf = new WordFactory(f);
		res = new String[] { "night", "night", "night", "night", "let", "s", "abc", "ab", "c", "abc", "abc", "ok-ok",
				"OK-OK", "ABC", "NANI-ANC", "AFA", "NI", "HABC" };
	}

	@Test
	public void testNext1() {
		String s = null;
		int i = 0;
		while ((s = wf.next()) != null) {
			assertEquals(s, res[i++]);
		}
	}

}
