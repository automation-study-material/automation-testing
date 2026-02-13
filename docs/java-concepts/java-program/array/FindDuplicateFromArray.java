package org.array;

public class FindDuplicateFromArray {

	public static void main(String[] args) {
		int [] ar= {2,5,4,6,5,7,8,5,5,7,2};
		int count;

		for (int i = 0; i < ar.length; i++) {			
			count = 1;
						
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[i] == ar[j] && ar[i] != ' ') {
					count++;
					ar[j] = ' ';
				}
			}
			if (count > 1 && ar[i] != ' ') {
				System.out.println(ar[i]);
			}
		}

	
	}
}
