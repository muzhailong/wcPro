package com.out;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map.Entry;

/**
 * 单词打印类
 * @author dengguofu
 *
 */
public class WordPrinter {
  private List<Entry<String, Integer>> res;
  private PrintWriter writer;

  /**
 * @param res 打印的结果集合
 * @param writer 打印输出流
 */
public WordPrinter(List<Entry<String, Integer>> res, PrintWriter writer) {
    this.res = res;
    this.writer = writer;
  }


/**
 * 执行打印操作
 */
public void print() {
    int sz = res.size();
    Entry<String, Integer> tmp = null;
    for (int i = 0; i < sz - 1; ++i) {
      tmp = res.get(i);
      writer.write(tmp.getKey() + " " + tmp.getValue() + "\r\n");
    }
    tmp = res.get(sz - 1);
    writer.write(tmp.getKey() + " " + tmp.getValue());
    writer.flush();
    writer.close();
  }
}
