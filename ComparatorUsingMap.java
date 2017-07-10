package com.subhjit.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ComparatorUsingMap {

	public static void main(String[] args) {
		Map<String,Integer>map = new HashMap<String,Integer>();
		map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);
        Set<Entry<String,Integer>>set = map.entrySet();
        List<Entry<String,Integer>>list = new ArrayList<Entry<String,Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
				return m1.getValue().compareTo(m2.getValue());
			}
        	
        });
        for(Map.Entry<String, Integer>entry : list) {
        	System.out.println(entry.getKey()+"==>"+entry.getValue());
        }
	}

}
