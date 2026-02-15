```java
package org.array;

public class Min_Max_From_Array {
	public static void main(String[] args) {
		int[] numbers = {-10,-2,-50,-80}; 
		int max = numbers[0]; 
		int min = numbers[0]; 
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i]; 
			} else if (numbers[i] < min) {
				min = numbers[i]; 
			}
		}
		System.out.println("The maximum number is: " + max);
		System.out.println("The minimum number is: " + min);
	}
}
```
