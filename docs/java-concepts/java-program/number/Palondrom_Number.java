package org.number;

public class Palondrom_Number {
	public static void main(String[] args) {
		int num=1221;
		int input=num;
		int rev=0;
		while(num>0) {
			int temp=num%10; //5 %reminder
			System.out.println("Mod :"+temp);
			rev=rev*10+temp;
			num=num/10;
			System.out.println("num :"+num);
		}
		if(input==rev)
			System.out.println("Given number is palindrom");
		else
			System.out.println("Not palindrom");
	}
}
