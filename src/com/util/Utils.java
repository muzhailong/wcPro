package com.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * 工具类
 * @author wangyuzhe
 *
 */
public class Utils {

	private Utils() {
	}

	/**
	 * 随机数类
	 */
	private static Random random = new Random();
	/**
	 * 合法字符集合
	 */
	private static String str = "abcddefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~`!"
			+ "#%^&*_…()[]+=-:'\"|<>,./? \n\t\r0123456789";

	/**
	 * @param fn 文件名
	 * @param sz 文件的大小 单位字节
	 */
	public static void randomFile(String fn, int sz) {
		File f = new File(fn);
		StringBuilder sb = new StringBuilder(sz * 2 / 3);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(f));
			char c = 0;
			int len = str.length();
			for (int i = 0; i < sz; ++i) {
				c = str.charAt(random.nextInt(len));
				sb.append(c);
			}
			writer.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 测试生成随机文件
	 * @param args 命令参数
	 */
	public static void main(String[] args) {
		String fn="2.txt";
		int sz=1024*1024*40;	
		randomFile(fn,sz);
	}
}
