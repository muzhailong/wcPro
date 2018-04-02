package com.in;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordFactory {
	private static int DEFAULT_CAPACITY = (int) 1e6;
	private static int CACHE_CAPACITY=4*1024;//缓存4k
	private static int INT2_LENGTH=65535;
	private static char[] nomalChars;
	private static boolean[]nomalArrs;
	
	static {
		nomalChars=new char[] {
				'~','`','!','#','%','^','&','*','_','…',
				'(',')','[',']','+','=','-',':',';','\'',
				'"','|','<','>',',','.','/','?',' ','\n',
				'\t'
		};
		nomalArrs=new boolean[INT2_LENGTH];
		for(char c:nomalChars) {
			nomalArrs[c]=true;
		}
	}
	
	private int capacity;
	private StringBuilder sb;
	private int pos;

	public WordFactory(File f, int capacity) {
		this.capacity = capacity;
		sb = new StringBuilder(capacity);
		preRead(f);
	}
	
	public WordFactory(File f) {
		this(f,DEFAULT_CAPACITY);
	}

	private void preRead(File f) {
		BufferedReader reader = null;
		try {
			reader=new BufferedReader(new FileReader(f));
			char[] buf=new char[CACHE_CAPACITY];
			int len=0;
			while((len=reader.read(buf))!=-1) {
				sb.append(buf,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String next() {
		StringBuilder word=new StringBuilder();
		int len=sb.length();
		while(pos<len&&isNomalChars(sb.charAt(pos))) {
			++pos;
		}
		while(pos<len&&isLetterChars(sb.charAt(pos))) {
			++pos;
		}
		int t=word.length()-1;
		while(t>=0&&isShortLine(word.charAt(t))) {
			--t;
		}
		if(t<0) {
			return next();
		}else {
			return word.substring(0,t+1);
		}
	}
	
	private boolean isNomalChars(char c) {
		return nomalArrs[c];
	}
	
	private boolean isLetterChars(char c) {
		return 'a'<=c&&c<='z'||c=='-';
	}
	
	private boolean isShortLine(char c) {
		return c=='-';
	}
}
