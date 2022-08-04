package DynamicProgramming;

import java.util.*;

public class CountPalindromicSubStrings {
	
	/**
	
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring(subarray) is a contiguous sequence of characters within the string.
	
abc
3	
	
	*/
	 public static int countSubstrings(String s) {
	        
	        boolean dp[][] = new boolean[s.length()][s.length()];
	        int count = 0;
	        
	         for(int g = 0; g < s.length(); g++){
	             for(int row = 0,col = g; col < dp.length; row++,col++){
	                 
	                 if(g == 0){
	                     dp[row][col] = true;
	                     
	                 } else if(g == 1){
	                     if(s.charAt(row) == s.charAt(col)){
	                         dp[row][col] = true;
	                     } else {
	                         dp[row][col] = false;
	                     }
	                     
	                 } else {
	                     if(s.charAt(row) == s.charAt(col) && dp[row + 1][col - 1] == true){
	                         dp[row][col] = true;
	                     } else {
	                         dp[row][col] = false;
	                     }
	                 }
	                 if(dp[row][col]){
	                     count++;
	                 }
	             }
	         }
	        
	        return count;
	    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int res = countSubstrings(str);
		 System.out.println(res);
		

	}

}
