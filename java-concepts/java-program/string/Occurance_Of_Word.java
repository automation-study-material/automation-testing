package org.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Occurance_Of_Word {
	public static void main(String[] args) {
		String str="aa bbc xyz aa bbc ddd xyz xyz xyz xyz aa";
		String [] arr=str.split(" ");
		//convert array into Set //Arrays.asList(arr) return LIST
		Set<String> set=new HashSet<String> (Arrays.asList(arr));
		int count=0;
		for(String s:set) {			
			for(int i=0;i<arr.length;i++) {
				if(s.equals(arr[i])) {
					count++;
				}
			}
			System.out.println(s+"--"+count);
			count=0;
		}
	}
}
