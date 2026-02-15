```java
package org.array;

public class Sorting_Array {

	public static void main(String[] args) {
        int[] numbers = {50, 30, 20, 40, 10};
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        System.out.println("The sorted array in ascending order is:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
		// Find 2nd Highest Number
		int max = array[array.length - 1];
		int secondHighest = -1;

		for (int i = array.length - 2; i >= 0; i--) {
    		if (array[i] != max) {
        		secondHighest = array[i];
       		 break;
    		}
    	}
}
```


