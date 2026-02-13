package org.string;

public class ShortName {
// synechrome 
	public static void main(String[] args) {
		String str="Mayuri Umesh Sonawane ssdsds";
		String [] arr=str.split(" ");
		String rev="";
		for(int i=0;i<arr.length;i++) {
			
			if(i!=arr.length-1) {
				char ch=arr[i].charAt(0);
				rev=rev+ch+".";
			}else {
				rev=rev+arr[i];
			}
		}
		System.out.println(rev);
	}
}
