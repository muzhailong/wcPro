package com.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 计数器，实现单词计数功能.
 * 
 * @author oldBook
 *
 */
public abstract class AbstractCounter {
    public static final int SZ = 100;
    public final int MAP_CAPACITY = 1024 * 512;
    protected Map<String, Integer> mp;
    protected List<Entry<String, Integer>> res;
    /**
     * 比较器
     */
    protected Comparator<Entry<String, Integer>> cmp = new Comparator<Entry<String, Integer>>() {
        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            if(o1==null&&o2==null) {
                return 0;
            }else if(o1==null) {
                return 1;
            }else if(o2==null) {
                return -1;
            }
            int t1 = 0, t2 = 0;
            if ((t1 = o1.getValue().intValue()) != (t2 = o2.getValue().intValue())) {
                return t2 - t1;
            }
            return o2.getKey().compareTo(o1.getKey());
        }
    };

    public AbstractCounter() {
        mp = new HashMap<String, Integer>(MAP_CAPACITY);
        res = new ArrayList<Entry<String, Integer>>(SZ);
    }

    /**
     * 运行比较器
     */
    public abstract void run();

    /**
     * 添加单词到散列表中
     * 
     * @param s
     *            单词
     */
    protected void add(String s) {
        if (mp.containsKey(s)) {
            mp.put(s, mp.get(s) + 1);
        } else {
            mp.put(s, 1);
        }
    }

    /**
     * 排序
     */
    public void sort() {
        defaultSort();
    }

    /**
     * 默认采用冒泡排序.
     */
    protected void defaultSort() {
        int sz = mp.size();
        List<Entry<String, Integer>> lt = new ArrayList<Entry<String, Integer>>(sz);
        for (Entry<String, Integer> e : mp.entrySet()) {
            lt.add(e);
        }
        for (int i = 0; i < sz - 1; ++i) {
            for (int j = 0; j < sz - i - 1; ++j) {
                if (cmp.compare(lt.get(j), lt.get(j + 1)) > 0) {
                    Entry<String, Integer> tmp = lt.get(i);
                    lt.set(i, lt.get(i + 1));
                    lt.set(i + 1, tmp);
                }
            }
        }
        for (int i = 0; i < SZ && i < sz; ++i) {
            res.add(lt.get(i));
        }
    }

    /**
     * @return 获取结果集合
     */
    public List<Entry<String, Integer>> get() {
        sort();
        return res;
    }
}
