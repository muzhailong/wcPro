package com.in;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LetterCharsTest {
	private char c;
	private WordFactory wf;
	private boolean respected;
	
	public LetterCharsTest(char c) {
		this.c = c;
		this.wf = new WordFactory();
		respected = ('a' <= c && c <= 'z') || c == '-'||('A'<=c&&c<='Z');
	}
	@Parameters
	public static Collection addedNumbers() {
		char[] nomalChars = "abcdefghijklmnopqrstuvwxyz-".toCharArray();
		List<Character> list = new ArrayList<Character>();
		for (char c : nomalChars) {
			list.add(c);
		}
		return list;
	}
	@Test
	public void testNomalChars() {
		Method m;
		try {
			m = Class.forName("com.in.WordFactory").getDeclaredMethod("isLetterChars", char.class);
			m.setAccessible(true);
			assertEquals(m.invoke(wf, c), respected);
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
