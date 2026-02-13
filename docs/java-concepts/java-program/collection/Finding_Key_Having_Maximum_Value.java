package org.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Finding_Key_Having_Maximum_Value {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(10, "Geeks");
		map.put(15, "4");
		map.put(20, "Geeks");
		map.put(25, "Welcomes");
		map.put(39, "You");
		Set<Entry<Integer, String>> bb = map.entrySet();
		int key=0;
		for(Entry<Integer, String> k:bb) {			
			if(k.getKey()>key){
				key=k.getKey();
			}			
		}
		System.out.println(key);
	}
}
