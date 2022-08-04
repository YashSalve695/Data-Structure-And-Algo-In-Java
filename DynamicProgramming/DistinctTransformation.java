package DynamicProgramming;

import java.util.*;

/**

1. You are given two strings S1 and S2.
2. You have to find the number of unique ways in which you can transform S1 to S2.
3. Transformation can be achieved by removing 0 or more characters from S1, 
   such that the sequence formed by the remaining characters of S1 is identical to S2.

abcccdf
abccdf

3

*/
public class DistinctTransformation {
	
	/** RECURSIVE + MEMOZATION */
	/** si -> source start index */
	/** ti -> target start index */
	public static int Transform_String(String s1, String s2, int si, int ti, int dp[][]) {
	
		if(si == s1.length()) {
			if(ti < s2.length()) {
				return 0;
			} else {
				return 1;
			}
		} else if(ti == s2.length()) {
			return 1;
		}
	 
	  if(dp[si][ti] != -1) {
		  return dp[si][ti];
	  }
		
	  char c1 = s1.charAt(si);
	  char c2 = s2.charAt(ti);
	  int total_ways = 0;
	  
	  if(c1 != c2) {
		  
		  total_ways = Transform_String(s1, s2, si + 1, ti, dp);
		  
	  } else {
		  int tw1 = Transform_String(s1, s2, si + 1, ti, dp);
		  int tw2 = Transform_String(s1, s2, si + 1, ti + 1, dp);
		  
		  total_ways = tw1 + tw2;
		  
	  }
	  dp[si][ti] = total_ways;
	  return total_ways;
	 
	}
	
	/** Tabulation */
	public static int Transform_String2(String source, String pattern) {
		
		int dp[][] = new int[pattern.length() + 1][source.length() + 1];
		
		for(int row = dp.length - 1; row >= 0; row--) {
			for(int col = dp[0].length - 1; col >= 0; col--) {
				
				if(row == dp.length - 1 && col == dp.length - 1) {
					dp[row][col] = 1;
					
				} else if(row == dp.length - 1) {
					dp[row][col] = 1;
					
				} else if(col == dp[0].length - 1) {
					dp[row][col] = 0;
					
				} else {
					
					char c1 = source.charAt(col);
					char c2 = pattern.charAt(row);
					
					if(c1 != c2) {
						
						dp[row][col] += dp[row][col + 1];
						
					} else {
						
						dp[row][col] += dp[row + 1][col + 1] + dp[row][col + 1];
					}
 				}
				
			}
		}
		
		return dp[0][0];
	}

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	String source = sc.next();
	String target = sc.next();
	
	int dp[][] = new int[source.length()][target.length()];
	
	 for(int i = 0; i < dp.length; i++) {
		 for(int j = 0; j < dp[0].length; j++) {
			 dp[i][j] = -1;
		 }
	 }
     int ans = Transform_String2(source, target);
      System.out.println(ans);
	}

}
