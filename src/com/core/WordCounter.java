package com.core;

import com.in.WordFactory;

public class WordCounter extends Counter {
	private WordFactory wf;

	public WordCounter(WordFactory wf) {
		this.wf = wf;
	}

	@Override
	public void run() {
		String s=null;
		while((s=wf.next())!=null) {
			add(s);
		}
	}
}
