package com.out;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.core.WordCounter;
import com.in.WordFactory;

public class WordPrinterTest {

    private static WordCounter wc;
    private static WordPrinter wp;
    private static File f;
    private static List<String> res;

    @BeforeClass
    public static void beforeClass() {
        WordFactory wf = new WordFactory(new File("run.txt"));
        wc = new WordCounter(wf);
        f = new File("tmp.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        res = new ArrayList<String>();
        res.add("abc 2");
        res.add("ok 1");
        res.add("e 1");
        res.add("cda 1");
    }

    @Test
    public void testPrint() {
        wc.run();
        List<Map.Entry<String, Integer>> lt = wc.get();
        PrintWriter writer;
        try {
            writer = new PrintWriter(new FileWriter(f));
            wp = new WordPrinter(lt, writer);
            wp.print();

            BufferedReader reader = new BufferedReader(new FileReader(f));
            String s = null;
            int i = 0;
            while ((s = reader.readLine()) != null) {
                assertEquals(s.trim(), res.get(i++));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void afterClass() {
        if (f.exists()) {
            f.delete();
        }
    }
}
