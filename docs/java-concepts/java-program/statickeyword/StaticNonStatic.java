package org.statickeyword;

public class StaticNonStatic {

	int a=15;
	 static int b=20;
	
	public static void main(String[] args) {
		// value is same for every instance i.e. 15;
		StaticNonStatic obj=new StaticNonStatic ();
		System.out.println(obj.a); //15
		obj.a=100; 
		System.out.println(obj.a);	//100
		StaticNonStatic obj1=new StaticNonStatic ();
		System.out.println(obj1.a); //15
		System.out.println(obj1.a=obj.a); //100
		
		//once you update it updated permanetly in case of static
		StaticNonStatic objstatic=new StaticNonStatic();
		System.out.println(objstatic.b); //20
		objstatic.b=150;
		System.out.println(objstatic.b); //150
		
		StaticNonStatic objstaticUpdate=new StaticNonStatic();
		System.out.println(objstaticUpdate.b); //150
		
		
		
	}
}
