package org.collection;

import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Getting_Value_of_required_key {
	
	public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("apple", "red");
        map.put("banana", "yellow");
        map.put("grape", "purple");
	System.out.println(getValue(map,"yellow"));
	}
		
		
	public static String getValue(Map<String, String> map,String value) {	
		Set<Entry<String, String>> entry = map.entrySet();		
		String key =null;
		for(Entry<String, String> k1 :entry) {
			 if(k1.getValue().contains(value)) {
				 key= k1.getKey();
			 }
		}
		return key;
	}
	
	
}
