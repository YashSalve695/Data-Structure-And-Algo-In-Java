package DynamicProgramming;

import java.util.*;

public class EditDistance {
	
	/**
	
1. You are given two strings s1 and s2.
2. You have to find the minimum number of operations needed to convert s1 to s2.
   Operations allowed are - 
   Insert - You can insert any character in s1.
   Remove - You can remove any character in s1.
   Replace - You can replace any character in s1 with any other character.	
   
pepperatcoding
pepcoding

5	
	
	*/
	public static int minDistance(String s1, String s2) {
		
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		
		for(int row = 0; row < dp.length; row++) {
			for(int col = 0; col < dp[0].length; col++) {
				
				if(row == 0) {
					dp[row][col] = col;
					
				} else if(col == 0) {
					dp[row][col] = row;
					
				} else {
					if(s1.charAt(row - 1) == s2.charAt(col - 1)) {
						dp[row][col] = dp[row - 1][col - 1];
						
					} else {
					
					int replace = dp[row - 1][col - 1] + 1;
					int delete = dp[row - 1][col] + 1;
					int insert = dp[row][col - 1] + 1;
					
					dp[row][col] = Math.min(replace, Math.min(delete, insert));
				}
				}
			}
		}
		return dp[s1.length()][s2.length()];
		
	}
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		int res = minDistance(s1, s2);
		 System.out.println(res);
		

	}

}
