package org.string;

public class Word_Ocurrance_inside_words_and_statement {
	public static void main(String[] args) {
		String given="ellumo umeshashahnawanesh applesume hmanglosha";
		String word="ume";
		System.out.println(test(given,word));
	}
	
	public static int test(String inputString,String word) {

		
		char first=' ';
		if(word.isEmpty()) {
			System.out.println("given word string is empty");
		}else {
			first=word.charAt(0);
		}
		String wordRepeated="";
		int count=0;
		for(int i=0;i<inputString.length();i++) {
			char ch=inputString.charAt(i);
			if(ch==first){
				for(int k=i;k<i+word.length();k++){
					if(k<inputString.length()) {
						char ch1=inputString.charAt(k);
						wordRepeated=wordRepeated+ch1;
					}
				}
				if(wordRepeated.equals(word)) {
					count++;
				}
			}
			else {
				wordRepeated="";
			}
		}
		return count;
	
	}
}

// String given="ellumo umeshashahnawanesh applesume hmanglosha";
// String word="ume"; // How many time specifi word occure in statment
