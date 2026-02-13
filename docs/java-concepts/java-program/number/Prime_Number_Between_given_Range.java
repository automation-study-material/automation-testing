package org.number;

import java.util.ArrayList;
import java.util.List;

public class Prime_Number_Between_given_Range {
	static List <Integer> prime=new ArrayList<Integer>();
	static List <Integer> notprime=new ArrayList<Integer>();
	public static void main(String[] args) {
		for(int i=1;i<100;i++) {
			prime(i);
		}
		System.out.println(prime);
		System.out.println(notprime);
	}
	public static void prime(int number) {
		int temp=0;
		int i;
		for(i=2;i<number;i++) {
			if(number%i==0) {
				temp=temp+1;
			}
		}
		if(temp==0) {
			prime.add(i);	
		}else {
			notprime.add(i);
		}
	}
}
