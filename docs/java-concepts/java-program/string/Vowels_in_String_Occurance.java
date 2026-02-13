package org.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Vowels_in_String_Occurance {

	public static void main(String[] args) {
		String str="helloee";
		str=str.toLowerCase();
		HashMap <Character,Integer> map=new HashMap <Character,Integer> ();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='a' || ch=='e' || ch=='e' || ch=='o' || ch=='u') {
				if(map.containsKey(ch)) {
					map.put(ch,map.get(ch)+1);
				}else {
					map.put(ch, 1);
				}
			}
		}
		System.out.println(map);
	}
}
