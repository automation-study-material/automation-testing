package org.oppos;
class Desktop{
	public  void test(int a,int b) {
		System.out.println("Desktop Class");
	}
}
class Demo extends Desktop{
	public  void test(int A) {
		System.out.println("Demo Class");
	}
}
class Car extends Demo{
	public  void test(int a,int b,int c){
		System.out.println("Car Class");
	}
}
class Driver extends Car{
	public  void test(int v){
		System.out.println("Driver Class");
	}
	public  void test(){
		System.out.println("Driver Class");
	}
}
public class Inheritance_Concept extends Driver {
	public  void test() {
		System.out.println("Test Class");
	}	
	public static void main(String[] args) {
		Driver obj=new Inheritance_Concept();
		obj.test();
	}
}
