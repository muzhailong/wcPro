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
public class ShortLineTest {
    private WordFactory wf;
    private boolean respected;
    private char c;

    public ShortLineTest(char c) {
        wf = new WordFactory();
        respected = c == '-';
        this.c = c;
    }

    @Parameters
    public static Collection addedNumbers() {
        char[] nomalChars = "asdjflajls-djf0812-34579~!@!~#@@#$#^$&%^(**&^^)&…FDAFD".toCharArray();
        List<Character> list = new ArrayList<Character>();
        for (char c : nomalChars) {
            list.add(c);
        }
        return list;
    }

    @Test
    public void testShortLine() {
        Method m;
        try {
            m = Class.forName("com.in.WordFactory").getDeclaredMethod("isShortLine", char.class);
            m.setAccessible(true);
            assertEquals(m.invoke(wf, c), respected);
        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
