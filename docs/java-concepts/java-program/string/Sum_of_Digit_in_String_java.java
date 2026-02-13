package org.string;

public class Sum_of_Digit_in_String_java {
	public static void main(String[] args) {
		int sum=0;
		String s = "dsdd5kdksdjs4kjdksd1skdjksd5";
		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			if (Character.isDigit(temp)) {
				sum=sum+Character.getNumericValue(temp);			
			}
		}System.out.println(sum);
    //=============Other Approach ============		
		s=s.replaceAll("[^0-9]","");
		System.out.println(s);
		int v=0;
		for(int i=0;i<s.length();i++) {
			//System.out.println(s.charAt(i));;
			//int a=Integer.parseInt(String.valueOf(s.charAt(i)));
			int a=s.charAt(i)-'0';;
			v=v+a;
		}
		System.out.println(v);
		

	}
}
