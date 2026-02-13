package org.array;

public class Reverse_Second_Half_Array2 {

	public static void main(String[] args){
		int [] a= {1,2,3,4,5,6};
		int [] a1= {1,2,3,4,5,6};

		test(a);
		System.out.println();
		test2(a1);

	}
	public static void test(int [] arr) {		
		int start =arr.length/2;		
		int end = arr.length-1;		
		int temp1;

		while(start<end){
			temp1 = arr[start];
			arr[start] = arr[end];
			arr[end] = temp1;
			start++;
			end--;
		}
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void test2(int [] a) {
		int size=a.length;
		for(int i=(size/2),j=size-1;i<j;i++,j--){
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
