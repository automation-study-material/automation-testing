package org.fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Delete_File {
	public static void main(String[] args) throws FileNotFoundException {
		File myObj = new File("C://Users//sonaw//OneDrive//Desktop//Git_Org//Java_Program//ganesh.txt");
		 
		myObj.delete();
	}
}
