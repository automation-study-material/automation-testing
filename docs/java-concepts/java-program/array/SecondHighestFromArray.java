package org.array;

public class SecondHighestFromArray {
	  public static void main(String[] args) {
	        int[] numbers = {10, 20, 30, 40, 50,40,-10,50};
	        int highest = Integer.MIN_VALUE; 
	        int secondHighest = Integer.MIN_VALUE; 	        
	        for (int i = 0; i < numbers.length; i++) {
	            if (numbers[i] > highest) {
	                secondHighest = highest; 
	                highest = numbers[i]; 
	            } else if (numbers[i] > secondHighest && numbers[i] != highest) {
	                secondHighest = numbers[i]; 
	            }
	        }
	        System.out.println("The second highest number is: " + secondHighest);
	    }
}
 //88058 82052