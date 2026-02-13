package org.traingle_Pattern_coforge;

public class A_BC_DEF_GHIJ {
public static void main(String[] args) {
	char ch='A'; //65 -74
	
	for(int i=1;i<=4;i++) {
		
		for(int j=1;j<=i;j++) {
			System.out.print(ch+ " ");
			ch++;
		}
		System.out.println();
	}
}
}

Output:
A 
B C 
D E F 
G H I J 
