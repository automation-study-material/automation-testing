package org.string;

public class Vowels_Consolent_count {

	public static void main(String[] args) {
		String str="umeaaash";
		str=str.toUpperCase();
		int vowel=0;
		int conso=0;
		for(int i=0;i<str.length();i++) {
			if(isvowel(str.charAt(i))) {
				vowel++;
			}else {
				conso++;
			}
		}
		System.out.println("Vowels :-"+vowel);
		System.out.println("conso :-"+conso);
		System.out.println("total:-"+(vowel+conso));
	}

	public static boolean isvowel(char ch) {		
		boolean flag=false;		
		if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
			flag=true;
		}else {
			flag=false;
		}
		return flag;

	}
}
