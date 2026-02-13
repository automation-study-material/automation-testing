package org.number;

public class Finobisis_Series {
	public static void main(String[] args) {

	int num=4;
	int a=0,b=0,c=1;
	
	for(int i=0;i<num;i++) {
		a=b;
		b=c;
		c=a+b;
		System.out.println(a);
	}
	
	}
}
