package org.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRederClass {

	public static void main(String[] args) throws IOException {
		String path="C://Users//sonaw//OneDrive//Desktop//Git_Org//Java_Program//umesh.txt";
		new FileRederClass().filereader(path,"ganesh");
	}
	
	public void filereader(String filepath,String text) throws IOException {
		FileReader reader=new FileReader(filepath);
		BufferedReader file= new BufferedReader(reader);
		  String line="";
		  String line1="";
		  while((line=file.readLine()) != null){ 
			  line1=line1+line+" ";
		  }
		  System.out.println(line1.trim());
		  String []  arr=line1.trim().split(" ");
		  boolean flag=false;
		  for(int i=0;i<arr.length;i++) {
			  String word=arr[i];
			  if(word.equals(text)){
				  System.out.println(word);
				  flag=true;
			  }
		  }
		  System.out.println(flag);
		reader.close();
	}
}
