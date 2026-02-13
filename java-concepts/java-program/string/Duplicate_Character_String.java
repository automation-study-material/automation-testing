package org.string;

public class Duplicate_Character_String {

	public static void main(String[] args) {
		String str = "helloumesh"; // o/p - hel
		int count;
		str = str.toLowerCase();
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {			
			count = 1;
						
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j] && charArray[i] != ' ') {
					count++;
					charArray[j] = ' ';
				}
			}
			if (count > 1 && charArray[i] != ' ') {
				System.out.println(charArray[i]);
			}
		}

	}
}
// Output :-  hel
