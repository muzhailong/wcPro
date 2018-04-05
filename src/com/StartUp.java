package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map.Entry;

import com.core.Counter;
import com.core.WordCounter;
import com.in.WordFactory;
import com.out.WordPrinter;
import com.param.ParamDecode;
import com.param.ParamDecode.Options;
import com.ui.WordSelector;

public class StartUp {
	static File defaultFile = new File("result.txt");
	public static void start(String[] args) {
		ParamDecode pd = new ParamDecode(args);
		Options op = pd.decode();
		if (op.isConsole) {// 控制台
			consoleStart(op);
		} else if (op.isX) {// 图形界面
			xStart();
		} else if (op.isErr) {// 错误
			err();
		}
	}

	public static void consoleStart(Options op) {
		String fn = op.getFn();
		File f = new File(fn);
		WordFactory wf = new WordFactory(f);
		Counter counter = new WordCounter(wf);
		counter.run();
		List<Entry<String, Integer>> res = counter.get();
		try {
			new WordPrinter(res, new PrintWriter(defaultFile)).print();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void xStart() {
		WordSelector ws = new WordSelector();
		File f = ws.select();
		WordFactory wf = new WordFactory(f);
		Counter counter = new WordCounter(wf);
		counter.run();
		List<Entry<String, Integer>> res = counter.get();
		try {
			new WordPrinter(res, new PrintWriter(defaultFile)).print();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void err() {
		System.out.println("error");
	}

	public static void main(String[] args) {
		args = new String[] { "1.txt" };
		start(args);
	}
}
