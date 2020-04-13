package com.wangrui.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
	
	public static void main(String[] args) {
	    Map<String, Integer> m = new HashMap<>();	
	    m.put(null, null);
	    
	    Map<String, Integer> tab = new Hashtable<>();
//	    tab.put(null, 1);
//	    tab.put("one", null);
	    
//	    ConcurrentHashMap<K, V>
	    
	    ConcurrentHashMap<String, Integer> cm = new ConcurrentHashMap<>();
	    cm.put(null, null);
	    
	}
}
