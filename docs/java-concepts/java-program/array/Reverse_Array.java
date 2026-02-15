package org.array;

public class Reverse_Array {

	public static void main(String[] args){
		int [] arr= {12,34,54,67,54,-5};
		int start =0;		
		int end = arr.length-1;		
		int temp;

		while(start<end){
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}

/*
Output:
-5 54 67 54 34 12 

*/
