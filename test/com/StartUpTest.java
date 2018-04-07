package com;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//黑盒测试 等价类划分
@RunWith(Parameterized.class)
public class StartUpTest {
  private String[] param;

  public StartUpTest(String p) {
    param = new String[] {p};
  }
  @Parameters
  public static List<String> toParam() {
    List<String> params = new ArrayList<String>();
    
    params.add("12.txt");
    params.add("1.txt");
    params.add("1.zip");
    params.add("-x" );
    return params;
  }
  @Test
  public void testStartUp() {
    StartUp.start(param);
  }
}
