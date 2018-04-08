package com.in;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 单词的工厂类，用于从指定文本中获取单词.
 * 
 * @author oldBook
 *
 */
public class WordFactory {
    private static int DEFAULT_CAPACITY = (int) 1e6;
    /**
     * 缓冲区大小.
     */
    private static int CACHE_CAPACITY =4 * 1024;
    /**
     * 两个字节的大小，用于保存字符标记.
     */
    /**
     * 单词的长度
     */
    private static int WORD_LENGTH = 40;
    private static int INT2_LENGTH = 65535;
    private static char[] nomalChars;
    private static boolean[] nomalArrs;
    private static StringBuilder word;
    
    static {
        nomalChars = new char[] { '~', '`', '!', '#', '%', '^', '&', '*', '_', '…', '(', ')', '[', ']', '+', '=', '-',
                ':', ';', '\'', '"', '|', '<', '>', ',', '.', '/', '?', ' ', '\n', '\t', '\r', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9' };
        nomalArrs = new boolean[INT2_LENGTH];
        for (char c : nomalChars) {
            nomalArrs[c] = true;
        }
        word = new StringBuilder(WORD_LENGTH);
    }

    private int capacity;
    private StringBuilder sb;
    private int pos;

    public WordFactory(File f, int capacity) {
        this.capacity = capacity;
        sb = new StringBuilder(capacity);
        preRead(f);
    }

    public WordFactory() {
    }

    public WordFactory(File f) {
        this(f, DEFAULT_CAPACITY);
    }

    /**
     * 将文件内容读取到内存中
     * @param f  预读文件
     */
    private void preRead(File f) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(f));
            char[] buf = new char[CACHE_CAPACITY];
            int len = 0;
            while ((len = reader.read(buf)) != -1) {
                sb.append(buf, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return 获取下一个单词
     */
    public String next() {
        word.setLength(0);
        int len = sb.length();
        if (pos >= len) {
            return null;
        }
        int t = -1;
        char c = 0;
        while (t < 0 && pos < len) {
            while (pos < len && isNomalChars(sb.charAt(pos))) {
                ++pos;
            }
            while (pos < len && isLetterChars(c = sb.charAt(pos))) {
                word.append(c);
                ++pos;
            }
            t = word.length() - 1;
            while (t >= 0 && isShortLine(word.charAt(t))) {
                --t;
            }
        }
        String result = word.substring(0, t + 1);
        return result.length() == 0 ? null : result;
    }
    

    /**
     * @param c 常规字符
     * @return true or false
     */
    private boolean isNomalChars(char c) {
        return nomalArrs[c];
    }

    /**
     * @param c 单词字符
     * @return true or false
     */
    private boolean isLetterChars(char c) {
        return 'a' <= c && c <= 'z' || c == '-' || ('A' <= c && c <= 'Z');
    }

    /**
     * @param c 短横线
     * @return true or false
     */
    private boolean isShortLine(char c) {
        return c == '-';
    }

    public StringBuilder getSb() {
        return this.sb;
    }
    
    public int getCapacity() {
        return capacity;
    }
}
