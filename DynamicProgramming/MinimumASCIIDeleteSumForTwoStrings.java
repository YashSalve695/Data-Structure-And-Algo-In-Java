package DynamicProgramming;

import java.util.*;


/**

1. You are given two strings S1 and S2.
2. You have to make these two strings equal by deleting characters. You can delete characters from any of the two strings.
3. The cost of deleting a character from any string is the ASCII value of that character.
4. You have to find the minimum ASCII sum of deleted characters.

sea
eat

231

*/
public class MinimumASCIIDeleteSumForTwoStrings {

	public static int Min_delete(String s1, String s2) {
		
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		
		 for(int row = dp.length - 1; row >= 0; row--) {
			 for(int col  = dp[0].length - 1; col >= 0; col--) {
				 
				 if(row == dp.length - 1 && col == dp[0].length - 1) {
					 dp[row][col] = 0;
					 
				 } else if(row == dp.length - 1) {
					 dp[row][col] = (int)s2.charAt(col) + dp[row][col + 1];
					 
				 } else if(col == dp[0].length - 1) {
					 dp[row][col] = (int)s1.charAt(row) + dp[row + 1][col];
					 
				 } else {
					 if(s1.charAt(row) == s2.charAt(col)) {
						 dp[row][col] = dp[row + 1][col + 1];
						 
					 } else {
						 
						 dp[row][col] = Math.min(s1.charAt(row) + dp[row + 1][col], 
								                 s2.charAt(col) + dp[row][col + 1]);
					 }
				 }
			 }
		 }
		
		return dp[0][0];
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		int ans = Min_delete(s1, s2);
		 System.out.println(ans);

	}

}
