package DynamicProgramming;

import java.util.*;

public class LongestCommonSubString {

	
	private static int LCS(String s1, String s2) {
		
		int max_length = 0;
		
		int dp[][] = new int[s1.length()][s2.length()];
		
		 for(int row = 1; row < dp.length; row++) {
			 for(int col = 1; col < dp.length; col++) {
				 
				 int chars1 = s1.charAt(row - 1);
				 int chars2 = s2.charAt(col - 1);
				 
				 if(chars1 != chars2) {
					 
					 dp[row][col] = 0;
					 
				 } else {
					 
					 dp[row][col] = dp[row - 1][col - 1] + 1;;
				 }
				 
				 if(dp[row][col] > max_length) {
					 max_length = dp[row][col];
				 }
			 }
		 }
		 
		return max_length;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		int ans = LCS(s1, s2);
		 System.out.println(ans);
		
		
	}

}
