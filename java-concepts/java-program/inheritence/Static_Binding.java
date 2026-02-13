package org.inheritence;

public class Static_Binding {
	/* 
	 * Static Binding The binding which can be resolved at compile time by the
	 * compiler is known as static or early binding. The binding of all the static,
	 * private, and final methods is done at compile-time.
	 * 
	 */
	// Static nested inner class
		// Class 1
		public static class superclass {

			// Method of inner class
			static void print()
			{
				System.out.println(
					"print() in superclass is called");
			}
		}

		// Static nested inner class
		// Class 2
		public static class subclass extends superclass {

			// Method of inner class
			static void print()
			{
				System.out.println(
					"print() in subclass is called");
			}
		}

		// Method of main class
		// Main driver method
		public static void main(String[] args)
		{

			// Creating objects of static inner classes
			// inside main() method
			superclass A = new superclass();
			superclass B = new subclass();

			// Calling method over above objects
			A.print(); // print() in superclass is called
			B.print(); // print() in superclass is called
		}
}
