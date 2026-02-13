package org.string;

import java.util.ArrayList;
import java.util.Scanner;

public class SubStrings {
	public static void main(String[] args) {

		String str="umesh";
		String str2=str.substring(0,4); // start index inclusive End index Exclusive
		System.out.println(str2); //umes


		//String str3=str.substring(2,5);
		//System.out.println(str3); //esh
		
		//String str4=str.substring(2,6);
		//System.out.println(str4); // Out of Index
		
		ArrayList <Integer> ar=new ArrayList <Integer> ();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array :");
		int size=sc.nextInt();
		int count=0;
		for(int i=0;i<size;i++) {
			System.out.println("enter value :"+(i+1));
			ar.add(sc.nextInt());
			if(ar.get(i)%2==0) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
