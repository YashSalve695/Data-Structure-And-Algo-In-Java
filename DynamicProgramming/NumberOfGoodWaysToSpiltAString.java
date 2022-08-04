package DynamicProgramming;

import java.util.*;

/**
 
You are given a string s.

A split is called good if you can split s into two non-empty strings 
sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) 
and the number of distinct letters in sleft and sright is the same.

Return the number of good splits you can make in s. 
 
Input: s = "aacaba"
Output: 2 
 
 */

public class NumberOfGoodWaysToSpiltAString {
	
	public static int numSpilt(String s) {
		
		int len = s.length();
		
		int prefix[] = new int[len];
		int suffix[] = new int[len];
		
		/** PREFIX ARRAY */
		int count = 0;
		int freq[] = new int[26];
		 for(int i = 0; i < len; i++) {
			 int ch = s.charAt(i) - 'a';
			 
			 freq[ch]++;
			 
			 if(freq[ch] == 1) {
				 count++;
			 }
			 prefix[i] = count;
		 }
		 
		 /** SUFFIX ARRAY */
		 count = 0;
		 freq = new int[26];
		 
		 for(int i = len - 1; i >= 0; i--) {
			 int ch = s.charAt(i) - 'a';
			 
			 freq[ch]++;
			 
			 if(freq[ch] == 1) {
				 count++;
			 }
			 suffix[i] = count;
		 }
		 
		 int spilt = 0;
		 
		  for(int i = 0; i < len - 1; i++) {
			  if(prefix[i] == suffix[i + 1]) {
				  spilt++;
			  }
		  }
		return spilt;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int ans = numSpilt(s);
		 System.out.println(ans);

	}

}
