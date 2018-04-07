package com.core;

import com.in.WordFactory;

/**
 * 单词计数器，计数器实现类.
 * 
 * @author oldBook
 *
 */
public class WordCounter extends AbstractCounter {
	private WordFactory wf;

	public WordCounter(WordFactory wf) {
		this.wf = wf;
	}

	@Override
	public void run() {
		String s=null;
		while((s=wf.next())!=null) {
			add(s.toLowerCase());
		}
	}
}
