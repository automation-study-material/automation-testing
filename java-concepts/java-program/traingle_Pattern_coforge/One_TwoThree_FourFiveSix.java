package org.traingle_Pattern_coforge;

public class One_TwoThree_FourFiveSix {

	public static void main(String[] args){
		test(4);
	}
	public static void test(int num) {
		int k=1;
		for(int i=1;i<num;i++){
			for(int j=1;j<=i;j++){
				System.out.print(k);
				k++;
			}
			System.out.println();
		}
	}
}

OutPut:
1
23
456
