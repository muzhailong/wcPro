package com.in;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class PreReadTest {

	@Test
	public void testPreTest1() {
		Method m;
		File f = new File("1.txt");
		WordFactory wf = new WordFactory(f);
		try {
			m = Class.forName("com.in.WordFactory").getDeclaredMethod("preRead", File.class);
			m.setAccessible(true);
			m.invoke(wf, f);
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalArgumentException
				| IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
