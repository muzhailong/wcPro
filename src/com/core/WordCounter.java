package com.core;

import java.util.Map.Entry;
import java.util.PriorityQueue;

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
        String s = null;
        while ((s = wf.next()) != null) {
            add(s.toLowerCase());
        }
    }

    /*
     * (non-Javadoc) 使用堆排序 覆盖原有的冒泡排序
     * 
     * @see com.core.AbstractCounter#sort()
     *
     * //
     */
    public void sort() {
        PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<Entry<String, Integer>>(mp.size(), cmp);
        for (Entry<String, Integer> e : mp.entrySet()) {
            pq.add(e);
        }
        for (int i = 0; i < SZ && !pq.isEmpty(); ++i) {
            res.add(pq.remove());
        }
    }

//    public void sort() {
//        int len = mp.size();
//        Entry<String,Integer>[] arr = new Entry[len];
//        int i = 0;
//
//        for (Entry<String, Integer> e : mp.entrySet()) {
//            arr[i++] = e;
//        }
//       Arrays.parallelSort(arr, cmp);
//
//        for (i = 0; i < SZ && i < len; ++i) {
//            res.add(arr[i]);
//        }
//    }

    // public void sort() {
    // Set<Entry<String, Integer>> st = new HashSet<Entry<String, Integer>>(SZ);
    // Entry<String, Integer> tmp = null;
    // int sz = mp.size();
    // for (int i = 0; i < SZ && i < sz; ++i) {
    // for (Entry<String, Integer> e : mp.entrySet()) {
    // if (cmp.compare(e, tmp) <=0 && !st.contains(e)) {
    // tmp = e;
    // }
    // }
    // res.add(tmp);
    // st.add(tmp);
    // }
    // }
}
