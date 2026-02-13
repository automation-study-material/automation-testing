package org.number;

public class Swapping_Two_Number_Without_Third_Variable {
	public static void main(String[] args) {
		int a=10,b=30;
		System.out.println("begore swap : a-"+a+"  -"+b);
		a=a+b; //a=40
		b=a-b; //40-30=10,b=10;
		a=a-b; //40-10=30,a=30;
		System.out.println("after swap : a-"+a+"  -"+b);		
	}
}
