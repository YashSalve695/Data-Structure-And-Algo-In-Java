package DynamicProgramming;

import java.util.*;

public class CountPalindromicSubsequence {
	
	/**
	
1. You are given a string str.
2. You are required to print the count of palindromic subsequences in string str.	
	
ccbbgd
8	
	
	*/
	private static int Count_Palin_Sub(String s1) {
		
		int dp[][] = new int[s1.length()][s1.length()];
		
         for(int gap = 0; gap < dp.length; gap++) {
        	 for(int row = 0, col = gap; col < s1.length(); row++,col++) {
        		 
        		 if(gap == 0) {
        			 dp[row][col] = 1;
        			 
        		 } else if(gap == 1) {
        			 dp[row][col] = s1.charAt(row) == s1.charAt(col) ? 3 : 2;
        			 
        		 } else {
        			  if(s1.charAt(row) == s1.charAt(col)) {
        				  dp[row][col] = dp[row][col - 1] + dp[row + 1][col] + 1;
        			  } else {
        				  dp[row][col] = dp[row][col - 1] + dp[row + 1][col] - dp[row + 1][col - 1];
        			  }
        		 }
        	 }
         }
		return dp[0][s1.length() - 1];
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int res = Count_Palin_Sub(str);
		 System.out.println(res);
		
	}

}
