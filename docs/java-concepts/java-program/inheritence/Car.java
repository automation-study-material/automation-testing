package org.inheritence;

public class Car {
	public static void main(String[] args) {
		Dog obj=new BabyDog ();
		obj.eat();
	}
}

class Test {
	void eat(){
		System.out.println("Test :eating...");
	} 
}

class Animal extends Test{  
	void eat(){
		System.out.println("Animal :eating...");
	}  
}  
class Dog extends Animal{  
	void eat(){
		System.out.println("Dog :eating...");
	} 
}  
class BabyDog extends Dog{  
	void eat(){
		System.out.println("BabyDog :eating...");
	} 
	public static void main(String[] args) {
		Animal obj=new Dog();
		obj.eat();
	}
}


