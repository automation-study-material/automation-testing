package org.collection;

import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Getting_Key_of_required_Value {
	
	public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("apple", "red");
        map.put("banana", "yellow");
        map.put("grape", "purple");
	System.out.println(getValue(map,"banana"));
	}
		
		
	public static String getValue(Map<String, String> map,String key) {	
		Set<Entry<String, String>> entry = map.entrySet();		
		String v=null;
		for(Entry<String, String> k1 :entry) {
			 if(k1.getKey().contains(key)) {
				 v= k1.getValue();
			 }
		}
		return v;
	}
}
