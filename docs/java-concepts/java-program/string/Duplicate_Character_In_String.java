package org.string;

public class Duplicate_Character_In_String {
	public static void main(String[] args) {
		String str="umeshuu";
		for(int i=0;i<str.length();i++) {		
			for(int j=i+1;j<str.length();j++) {		
				if(str.charAt(i)==str.charAt(j)) {
					System.out.print(str.charAt(i)); //ol
				}
			}
		}
	}
}
