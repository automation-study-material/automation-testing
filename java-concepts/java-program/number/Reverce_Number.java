package org.number;

public class Reverce_Number {
	public static void main(String[] args) {
		 revrese();
		int num=12345;
		int rev=0;
		while(num>0) {
			int temp=num%10; //5 %reminder
			System.out.println("Mod :"+temp);
			rev=rev*10+temp;
			num=num/10;
			System.out.println("num :"+num);
		}
		System.out.println("rev :"+rev);
	}	
	public static void revrese() {
		int a=2670;
		String nu=String.valueOf(a);
		System.out.println(nu);
		StringBuilder obj=new StringBuilder(nu);
		obj.reverse();
		String output = obj.toString();
		System.out.println("output :"+output);
		Integer.parseInt(output);
		System.out.println(Integer.parseInt(output));
	}
}
