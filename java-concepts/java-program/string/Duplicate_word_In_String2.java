package org.string;

public class Duplicate_word_In_String2 {
	public static void main(String[] args) {
		String str="pune hub is best city pune is is It hub";
		int count;
		str = str.toLowerCase();
		String [] charArray = str.split(" ");
		for (int i = 0; i < charArray.length; i++) {			
			count = 1;
						
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j] && charArray[i] !=" ") {
					count++;
					charArray[j] = " ";
				}
			}
			if (count > 1 && charArray[i] != " ") {
				System.out.println(charArray[i]);
			}
		}
	
	}
}
