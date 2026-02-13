package org.fileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckSpecificWordPresentInProgram {

	
	public static void main(String args[]) throws FileNotFoundException {
		CheckSpecificWordPresentInProgram obj=new CheckSpecificWordPresentInProgram();
		
		obj.test("text","C:\\Users\\sonaw\\OneDrive\\Desktop\\Git_Org\\ssa.txt");
		
	}
	
	public void test(String word,String path) throws FileNotFoundException {
	     
	      boolean flag = false;
	      int count = 0;	      
	      //Reading the contents of the file
	      Scanner sc2 = new Scanner(new FileInputStream(path));
	      while(sc2.hasNextLine()) {
	         String line = sc2.nextLine();
	         System.out.println(line);
	         if(line.indexOf(word)!=-1) {
	            flag = true;
	            count = count+1;
	         }
	      }
	      if(flag) {
	         System.out.println("Number of occurrences" + word +"  "+ count);
	      } else {
	         System.out.println("File does not contain "+ word +" word");
	      }
	   
	}
}
