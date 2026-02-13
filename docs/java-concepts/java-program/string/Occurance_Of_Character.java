package org.string;

public class Occurance_Of_Character {
	public static void main(String[] args) {
		String s="aaabbcccdddd";
		int count = 0 ;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(i)==s.charAt(j))
					count++;           
			}   
			System.out.println(s.charAt(i)+"-"+count);
			String d=String.valueOf(s.charAt(i)).trim();
			s=s.replaceAll(d,"");
			count = 0;
		}
	}
}
