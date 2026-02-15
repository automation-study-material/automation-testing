package org.array;
import java.util.ArrayList;
public class FindUniqueFromArray {
	public static void main(String[] args) {
		int [] ar={20,22,11,33,20,22,11,34};
		int count=0;
		ArrayList<Integer> list=new ArrayList <Integer>();
		for(int i=0;i<ar.length;i++) {
			int flag=0;	
			for(int j=0;j<ar.length;j++) {
				if(ar[i]==ar[j] && i!=j) {
					flag=1;
					break;
				}
			}
			if(flag==0) {
				list.add(ar[i]); 
				System.out.println(ar[i]);
			}
		}
		System.out.println(list);
	}
}

/*
Output:
33
34
878
[33, 34, 878]
*/

