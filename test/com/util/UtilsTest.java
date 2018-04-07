package com.util;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void testRandomFile() {
        Utils.randomFile("tmp.txt", 1024 * 1024 * 10);
    }
}
