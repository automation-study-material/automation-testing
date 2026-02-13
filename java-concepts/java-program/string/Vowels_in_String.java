package org.string;

import java.util.HashSet;
import java.util.Set;

public class Vowels_in_String {

	public static void main(String[] args) {
		String str="helloee";
		str=str.toLowerCase();
		Set<Character> set=new HashSet <Character>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='a' || ch=='e' || ch=='e' || ch=='o' || ch=='u') {
				set.add(ch);
			}
		}
		System.out.println(set);
	}
}
