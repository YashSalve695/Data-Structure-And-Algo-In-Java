package DynamicProgramming;

import java.util.*;

public class LargestSquareSubmatrixOfAll1s {
	
	
	/**
	
1. You are given a matrix of 0's and 1's.
2. You have to find the maximum size square sub-matrix with all 1's.

5 6
0 1 0 1 0 1 
1 0 1 0 1 0 
0 1 1 1 1 0 
0 0 1 1 1 0 
1 1 1 1 1 1

3
	
	
	*/
	private static int Maximal_Square(int matrix[][]) {
		
		int ans = 0;
		int dp[][] = new int[matrix.length][matrix[0].length];
		
		for(int row = dp.length - 1; row >= 0; row--) {
			for(int col = dp[0].length - 1; col >= 0; col--) {
				
				if(row == dp.length - 1 && col == dp[0].length) {
				dp[row][col] = matrix[row][col];
				
				 } else if(row == dp.length - 1) {
					 dp[row][col] = matrix[row][col];
					 
				 } else if(col == dp[0].length - 1) {
					 dp[row][col] = matrix[row][col];
					 
				 } else {
					 if(matrix[row][col] == 0) {
						 dp[row][col] = 0;
						 
					 } else {  /**                 rightside     downside           */
						 int min = Math.min(dp[row][col + 1], dp[row + 1][col]);
						     min = Math.min(min, dp[row + 1][col + 1]);/** Diagonal check */
						     
						     dp[row][col] = min + 1;
						     
						     if(dp[row][col] > ans) {
						    	 ans = dp[row][col];
						     }
					 }
				 }
			}
		}
	
//		for(int i = 0; i < dp.length; i++) {
//			for(int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
		
		return ans;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int matrix[][] = new int[r][c];
		 for(int i = 0; i < r; i++) {
			 for(int j = 0; j < c; j++) {
				 matrix[i][j] = sc.nextInt();
			 }
		 }
				
       int ans = Maximal_Square(matrix);
        System.out.println(ans);
	}

}
