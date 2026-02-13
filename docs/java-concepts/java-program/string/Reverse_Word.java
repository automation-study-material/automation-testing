package org.string;

public class Reverse_Word {
	public static void main(String[] args){
		String str="hi my name is umesh";
		String [] arr=str.split(" ");
		String rev="";
		for(int i=arr.length-1;i>=0;i--){
		rev=rev+arr[i]+" ";	
		}
		System.out.println(rev);
		rev=rev.trim();
		System.out.println(rev);	
	}
}
