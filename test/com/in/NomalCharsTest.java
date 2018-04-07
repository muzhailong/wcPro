package com.in;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NomalCharsTest {
    private char c;
    private WordFactory wf;
    private boolean respected;
    private static char[] nomalChars;
    private static boolean[] nomalArrs;

    static {
        nomalChars = new char[] { '~', '`', '!', '#', '%', '^', '&', '*', '_', '…', '(', ')', '[', ']', '+', '=', '-',
                ':', ';', '\'', '"', '|', '<', '>', ',', '.', '/', '?', ' ', '\n', '\t', '\r', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9' };
        nomalArrs = new boolean[65535];
        for (char c : nomalChars) {
            nomalArrs[c] = true;
        }
    }

    public NomalCharsTest(char c) {
        this.c = c;
        this.wf = new WordFactory();
        respected = nomalArrs[c];
    }

    @Parameters
    public static List<Character> addedNumbers() {
        char[] nomalChars = "asdjflajlsdjf081234579~!@!~#@@#$#^$&%^(**&^^)&…FDAFD".toCharArray();
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
            m = Class.forName("com.in.WordFactory").getDeclaredMethod("isNomalChars", char.class);
            m.setAccessible(true);
            assertEquals(m.invoke(wf, c), respected);
        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
