package org.string;

import java.util.Arrays;

public class Longest_Substring_count_string {
	
	 public static String findLongestSubstring(String str) {
	        int n = str.length();
	        int maxLength = 0;  // Length of longest substring
	        int start = 0;     // Starting index of substring
	        int end = 0;       // Ending index of substring

	        // Create a boolean array to track characters
	        boolean[] visited = new boolean[256];
	        
	        // Initialize all characters as not visited
	        Arrays.fill(visited, false);

	        // Traverse the input string
	        for (int i = 0; i < n; i++) {
	            for (int j = i; j < n; j++) {
	                // If current character is already visited,
	                // break the inner loop
	                if (visited[str.charAt(j)]) {
	                    break;
	                }
	                else {
	                    visited[str.charAt(j)] = true;
	                    int currentLength = j - i + 1;
	                    if (currentLength > maxLength) {
	                        maxLength = currentLength;
	                        start = i;
	                        end = j;
	                    }
	                }
	            }
	            
	            // Reset the visited array for the next iteration
	            Arrays.fill(visited, false);
	        }
	        
	        // Extract the longest substring
	        String longestSubstring = str.substring(start, end + 1);
	        return longestSubstring;
	    }

	    public static void main(String[] args) {
	        String input = "abcabcxyzklmno";
	        String longestSubstring = findLongestSubstring(input);
	        System.out.println("Longest substring: " + longestSubstring);
	    }
}
