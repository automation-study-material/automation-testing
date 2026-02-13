package org.string;

public class Reverce_String_with_String_buider {


	public static void main(String[] args) {
		String str="hello";		
		StringBuilder obj=new StringBuilder(str);
		obj.reverse();
		System.out.println(obj.toString());
	}
}
