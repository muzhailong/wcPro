package com.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Utils {

	private Utils() {
	}

	private static Random random = new Random();
	private static String str = "abcdefghijklmnopqrstuvwxyz~`!"
			+ "#%^&*_…()[]+=-:'\"|<>,./? \n\t\r0123456789";

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
	public static void main(String[] args) {
		String fn="1.txt";
		int sz=1024*1024*40;//40M
		randomFile(fn,sz);
	}
}
