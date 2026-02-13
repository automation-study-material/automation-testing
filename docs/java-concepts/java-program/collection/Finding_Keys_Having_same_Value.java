package org.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Finding_Keys_Having_same_Value {

	public static void main(String[] args) {

		//temp1 = { "case" : "10", 
		//			 "name" : "xyz"}
		//temp2 = { "city" : "Pune"}
		//temp3 = { "number" : "10"}


		HashMap <String,String> temp1=new HashMap <String,String> ();
		temp1.put("case", "10");
		temp1.put("name", "xyz");
		temp1.put("city", "Pune");
		temp1.put("Number", "10");
		
		System.out.println(temp1);

		List<String>  list=new ArrayList <String> ();
		List<String>  duplicateValues=new ArrayList <String> ();
		
		Collection<String> va = temp1.values();
		for(String kk:va) {
			list.add(kk);
		}
		System.out.println(list);

		for(int i=0;i<list.size();i++) {
			//System.out.println("list.get("+i+") : i :"+list.get(i));
			for(int j=i+1;j<list.size();j++) {
				//System.out.println("list.get("+j+") j:"+list.get(j));
				if(list.get(i).equals(list.get(j))){
					duplicateValues.add(list.get(i));
				}
			}
		}
		System.out.println(duplicateValues);

		Set<String> k = temp1.keySet();
		for(String key:k) {
			for(int i=0;i<duplicateValues.size();i++) {
				String du=(String) duplicateValues.get(i);
				if(temp1.get(key).equals(du)) {
					System.out.println("value : "+du+"   "+key);
				}
			}			
		}
		
	
	}
}
