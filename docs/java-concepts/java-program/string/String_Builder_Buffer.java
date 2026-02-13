package org.string;

public class String_Builder_Buffer {
	
		public static void concat1(String s1)
		{
			s1 = s1 +"forgeeks";
		}


		public static void concat2(StringBuilder s2)
		{
			s2.append("forgeeks");
		}


		public static void concat3(StringBuffer s3)
		{
			s3.append("forgeeks");
		}


		public static void main(String[] args)
		{

			String s1 = "Geeks";
			concat1(s1);
			System.out.println("String: " + s1);
			// s1= Geeks
			
			StringBuilder s2 = new StringBuilder("Geeks");
			concat2(s2);
			System.out.println("StringBuilder: " + s2);
			// Geeksforgeeks

			StringBuffer s3 = new StringBuffer("Geeks");
			concat3(s3);
			System.out.println("StringBuffer: " + s3);
			// Geeksforgeeks
		}
	}


