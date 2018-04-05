package com.ui;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class WordSelectorTest {
	@Test
	public void testX() {
		WordSelector ws = new WordSelector();
		File s = ws.select();
		//选择D:\project\study\wcPro\1.txt文件
		assertEquals(s.getAbsolutePath(),"D:\\project\\study\\wcPro\\1.txt");
	}
}
