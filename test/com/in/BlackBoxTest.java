package com.in;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlackBoxTest {
	private static WordFactory wf;
	private static File f;
	private static List<String> res;

	@BeforeClass
	public static void bc() {
		f = new File("tmp.txt");
		BufferedWriter writer = null;
		res = new LinkedList<String>();
		try {
			writer = new BufferedWriter(new FileWriter(f));
			writer.write("-night- 123an-ab");
			writer.flush();
			res.addAll(Arrays.asList(new String[] { "night", "an-ab" }));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testNext() {
		wf = new WordFactory(f);
		for (String s : res) {
			assertEquals(s, wf.next());
		}
	}
	@AfterClass
	public static void ac() {
		if (f.exists())
			f.delete();
	}

}
