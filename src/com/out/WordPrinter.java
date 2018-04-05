package com.out;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map.Entry;
public class WordPrinter {
	private List<Entry<String, Integer>> res;
	private PrintWriter writer;
	public WordPrinter(List<Entry<String, Integer>> res,PrintWriter writer) {
		this.res = res;
		this.writer=writer;
	}
	public void print() {
		int sz=res.size();
		Entry<String, Integer> tmp=null;
		for(int i=0;i<sz-1;++i) {
			tmp=res.get(i);
			writer.write(tmp.getKey()+" "+tmp.getValue()+"\r\n");
		}
		tmp=res.get(sz-1);
		writer.write(tmp.getKey()+" "+tmp.getValue());
		writer.flush();
		writer.close();
	}
}
