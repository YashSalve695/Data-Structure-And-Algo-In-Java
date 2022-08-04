package DynamicProgramming;

import java.util.*;

public class PalindromicPartitionWithMinCuts {
	
	
	/**

1. You are given a string.
2. You have to find the minimum number of cuts required to convert the given string into 
   palindromic partitions.
3. Partitioning of the string is a palindromic partitioning if every substring of the 
   partition is a palindrome.
   
abccbc
2   

*/
	public static int minPalindromicCut1(String s) { /** N^3 */
		
		boolean dp[][] = new boolean[s.length()][s.length()];
		
		for(int gap = 0; gap < s.length(); gap++) {
			for(int row = 0, col = gap; col < dp.length; row++, col++) {
				
				if(gap == 0) {
					dp[row][col] = true;
					
				} else if(gap == 1) {
					dp[row][col] = s.charAt(row) == s.charAt(col);
					
				} else {
					if(s.charAt(row) == s.charAt(col) && dp[row + 1][col - 1] == true) {
						dp[row][col] = true;
						
					} else {
						dp[row][col] = false;
					}
				}
			}
		}
		int storage[][] = new int[s.length()][s.length()];
		
		 for(int gap = 0; gap < s.length(); gap++) {
			 for(int row = 0, col = gap; col < s.length(); row++, col++) {
				 
				 if(gap == 0) {
					 storage[row][col] = 0;
					 
				 } else if(gap == 1) {
					 if(s.charAt(row) == s.charAt(col)) {
						 storage[row][col] = 0;
						 
					 } else { 
						 storage[row][col] = 1;
					 } 
				 }else{
						 if(dp[row][col]) {
							 storage[row][col] = 0;
						 
						   
						 } else {
							 int min = Integer.MAX_VALUE;
							 for(int k = row; k < col; k++) {
								 int left = storage[row][k];
								 int right = storage[k + 1][col];
								 
								 if(left + right + 1 < min) {
									 min = left + right + 1;
								 }
							 }
							 storage[row][col] = min;
						 }
						 
					 }
				 }
			 }
		 

		 return storage[0][s.length() - 1];
	}
	
	/** Gap Strategy N^2*/ 
	public static int minPalindromicCut2(String s) {
		
    boolean dp[][] = new boolean[s.length()][s.length()];
		
		for(int gap = 0; gap < s.length(); gap++) {
			for(int row = 0, col = gap; col < dp.length; row++, col++) {
				
				if(gap == 0) {
					dp[row][col] = true;
					
				} else if(gap == 1) {
					dp[row][col] = s.charAt(row) == s.charAt(col);
					
				} else {
					if(s.charAt(row) == s.charAt(col) && dp[row + 1][col - 1] == true) {
						dp[row][col] = true;
						
					} else {
						dp[row][col] = false;
					}
				}
			}
		}
		int dp1[] = new int[s.length()];
		dp1[0] = 0;
		
		for(int start = 1; start < dp1.length; start++) {
			if(dp[0][start]) {
				dp1[start] = 0;
				
			} else {
			
			for(int end = start; end >= 1; end--) {
				int min = Integer.MIN_VALUE;
				
				if(dp[start][end]) {
					
					if(dp1[start - 1] < min) {
						min = dp1[start - 1];
					}
				}
			}
			}
				dp1[end] = min + 1;
			}
			
		}
		return dp1[s.length() - 1];
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut2(str));
	}

}
