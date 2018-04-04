package com.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public abstract class Counter {
	private static final int SZ=100;
	
	protected Map<String, Integer> mp;
	protected List<Entry<String,Integer>> res;
	
	public Counter() {
		mp = new HashMap<String, Integer>();
		res=new ArrayList<Entry<String,Integer>>(SZ);
	}
	
	public abstract void run();
	
	protected void add(String s) {
		if (mp.containsKey(s)) {
			mp.put(s, mp.get(s) + 1);
		} else {
			mp.put(s, 1);
		}
	}

	protected void sort() {
		PriorityQueue<Entry<String,Integer>> pq=
				new PriorityQueue<Entry<String,Integer>>(mp.size(),
						new Comparator<Entry<String,Integer>>(){
							@Override
							public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
								int t1=0,t2=0;
								if((t1=o1.getValue().intValue())!=(t2=o2.getValue().intValue())) {
									return t2-t1;
								}
								return o2.getKey().compareTo(o1.getKey());
							}
				});
		for(Entry<String,Integer> e:mp.entrySet()) {
			pq.add(e);
		}
		
		for(int i=0;i<SZ;++i) {
			res.add(pq.remove());
		}
	}
	
	public List<Entry<String,Integer>> get(){
		sort();
		return res;
	}
}
