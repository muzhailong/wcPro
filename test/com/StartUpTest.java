package com;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//黑盒测试 等价类划分
@RunWith(Parameterized.class)
public class StartUpTest {
	private String[] param;

	public StartUpTest(String[] p) {
		param = p;
	}

	@Parameters
	public static List<String[]> toParam() {
		return Arrays.asList(new String[] { "-x" }, new String[] { "1.txt" }, new String[] { "12.txt" },
				new String[] { "1.zip" });
	}
	
	@Test
	public void testStartUp() {
		StartUp.start(param);
	}
}
