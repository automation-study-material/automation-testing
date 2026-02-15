```java
package org.array;

public class Reverse_First_Half_Array {

	public static void main(String[] args){
		int [] a= {1,2,3,4,5,6};		
		int size=a.length;
		System.out.println(size);
		
		
		for(int i=0,j=(size/2)-1;i<j;i++,j--){
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
		}
	}
}

```
