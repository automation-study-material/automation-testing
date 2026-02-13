package org.traingle_Pattern_coforge;

public class Star_RTriangle_Pattern {
	public static void main(String[] args){
		  int alphabet = 65;
	        System.out.println("** Printing the pattern... **");
	        for (int i = 0; i <= 5; i++){
	            for (int j = 0; j <= i; j++){
	                System.out.print((char) alphabet + " ");
	            }
	            alphabet++;
	            System.out.println();
	        }
	}
}
Out-Put:

A 
B B 
C C C 
D D D D 
E E E E E 
F F F F F F 
