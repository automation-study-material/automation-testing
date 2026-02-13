package org.string;

public class ReplaceAll_Method {
public static void main(String[] args) {
	
	String str="!@#u$%m#@$e*&^s*&^%$#h"; 
	str=str.replaceAll("[!@#%^&$*]",""); //umesh	
	//str=str.replaceAll("[^!@#%^&$*]",""); //!@#$%#@$*&^*&^%$#
	
	String str1="43434u243435m43e5674sh321";
	//str1=str1.replaceAll("[0-9]",""); //umesh
	str1=str1.replaceAll("[^0-9]","");//43434243435435674321
	System.err.println(str1);

	String str2= "This#string%contains^special*characters&.";   
	str2 = str2.replaceAll("[^a-zA-Z0-9]", " "); // ^ indiacte we want that all character 
	//This string contains special characters 
	System.err.println(str);
	
	
}
}
