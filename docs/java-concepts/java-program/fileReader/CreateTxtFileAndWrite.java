package org.fileReader;

import java.io.File;

public class CreateTxtFileAndWrite {
	public static void main(String[] args) {
		File file = new File("C:/Users/sonaw/OneDrive/Desktop/Git_Org/JavaFile.java");

		try {

			// create a new file with name specified
			// by the file object
			boolean value = file.createNewFile();
			if (value) {
				System.out.println("New Java File is created.");
			}
			else {
				System.out.println("The file already exists.");
			}
		}catch(Exception ele) {
			
		}
	}
}
	

