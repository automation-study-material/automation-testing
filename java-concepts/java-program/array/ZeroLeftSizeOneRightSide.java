package org.array;
public class ZeroLeftSizeOneRightSide {
	public static void main(String[] args) {
		int [] ar= {1,0,0,1,1,1,0,0,0};
		int[] ar1 = separate0s1sSolution1(ar);
		for(int i=0;i<ar1.length;i++) {
			System.out.print(ar1[i]);
		}
	}
	public static int[] separate0s1sSolution1(int arr[])
	 {
	  int count=0;
	  for (int i = 0; i < arr.length; i++) {
	   if(arr[i]==0)
	   {
	    count++;
	   }
	  }
	  for (int i = 0; i < count; i++) {
	   arr[i]=0;
	  }
	  for (int i = count; i < arr.length; i++) {
	   arr[i]=1;
	  }
	  return arr;
	 }
}
