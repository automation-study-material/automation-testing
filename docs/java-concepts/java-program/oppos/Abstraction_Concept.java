package org.oppos;

abstract class A{
	public abstract void test1();
	public abstract void test2();
	public abstract void test3();

	public void demo() {
		System.out.println("abstract class A : demo method");
	}
}
abstract class B extends A{

	public void test1() {
		System.out.println("B class - test1 ");

	}
	public void test2() {
		System.out.println("B class - test2 ");

	}
}

class C extends B{

	public void test1() {
		System.out.println("C class - test1 ");

	}
	public  void test2() {
		System.out.println("C class - test2 ");

	}
	public  void test3() {
		System.out.println("C class - test3 ");

	}
}

class D extends A{
	public void test1() {
		System.out.println("D class - test1 ");
	}
	public  void test2() {
		System.out.println("D class - test2");

	}
	public  void test3() {
		System.out.println("D class - test3");

	}
}
public class Abstraction_Concept {
	public static void main(String[] args) {
		B obj=new C();
		obj.test1();
		obj.test2();
		obj.test3();

		
		
	}
}
