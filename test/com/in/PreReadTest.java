package com.in;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class PreReadTest {

	private static String res="abc cda e--- ok abc";
	@Test
	public void testPreTest1() {
		Method m;
		File f = new File("run.txt");
		WordFactory wf = new WordFactory(f);
		try {
			m = Class.forName("com.in.WordFactory").getDeclaredMethod("preRead", File.class);
			m.setAccessible(true);
			m.invoke(wf, f);
			assertEquals(res,wf.getSb().toString());
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalArgumentException
				| IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
