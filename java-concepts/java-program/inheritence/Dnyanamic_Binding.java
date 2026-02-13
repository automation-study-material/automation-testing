package org.inheritence;

public class Dnyanamic_Binding {
	// Static nested inner class
		// Class 1
		public static class superclass {

			// Method of inner class 1
			void print()
			{
				System.out.println(
					"print in superclass is called");
			}
		}

		// Static nested inner class
		// Class 2
		public static class subclass extends superclass {

			// Method of inner class 2
			@Override void print()
			{
				System.out.println(
					"print in subclass is called");
			}
		}

		// Method inside main class
		public static void main(String[] args)
		{

			// Creating object of inner class 1
			// with reference to constructor of super class
			superclass A = new superclass();

			// Creating object of inner class 1
			// with reference to constructor of sub class
			superclass B = new subclass();

			// Calling print() method over above objects
			A.print(); // print in superclass is called
			B.print(); // print in subclass is called
		}

}
