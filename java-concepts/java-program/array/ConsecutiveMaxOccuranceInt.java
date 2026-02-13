package org.array;

public class ConsecutiveMaxOccuranceInt {

	public static void main(String[] args) {

		int [] ar={0,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1};
		int count=0;
		int max=0;
		for(int i=0;i<ar.length;i++) {
			if(ar[i]==1) {
				count++;
				
				if(count>max) {
					max=count;
				}
			}else {
				
				
				count=0;
			}
		}
		System.out.println(max);
	
	}
}
