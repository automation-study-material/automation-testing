package org.number;

public class Armstrong_Number {
	public static void main(String[] args) {

		int number=153;
		//153: 13 + 53 + 33 = 1 + 125+ 27 = 153
		int input=number;		
		int pa=0;
		int sum=0;	
		while(input>0) {
			pa=input%10;
			pa=pa*pa*pa;
			sum=sum+pa;
			input=input/10;
		}
		if(sum==number) {
			System.out.println("No is Armstrong");
		}
			
	}
}
