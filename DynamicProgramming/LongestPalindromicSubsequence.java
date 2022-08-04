package DynamicProgramming;

import java.util.*;

public class LongestPalindromicSubsequence {
	
	public static void print(int arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
		
	private static int Longest_Sub(String str) {
		
		int dp[][] = new int[str.length()][str.length()];
		
		 for(int gap = 0; gap < dp.length; gap++) {
			 for(int row = 0, col = gap; col < str.length(); row++, col++) {
				 
				 if(gap == 0) {
					 dp[row][col] = 1;
					 
				 } else if(gap == 1) {
					 dp[row][col] = str.charAt(row) == str.charAt(col) ? 2 : 1;
					  /** if string is cc -> then subSeq is c, c, cc , longest of all is cc 
					      which is 2 length*/
				 } else {
					 
					 if(str.charAt(row) == str.charAt(col)) {
						 dp[row][col] = 2 + dp[row + 1][col - 1];
						 
					 } else {
						 
						 dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
					 }
				 }
			 }
		 }
		 print(dp);
		return dp[0][str.length() - 1];
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		 int res = Longest_Sub(str);
		  System.out.println(res);

	}

}



/**

1 1 1 1 2 4 4 
0 1 1 1 2 4 4 
0 0 1 1 2 2 3 
0 0 0 1 2 2 3 
0 0 0 0 1 1 3 
0 0 0 0 0 1 1 
0 0 0 0 0 0 1 



*/