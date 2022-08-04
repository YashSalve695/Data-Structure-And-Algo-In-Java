package DynamicProgramming;

import java.util.*;

public class PaintHouse {
	
	
	/**

1. You are given a number n, representing the number of houses.

2. In the next n rows, you are given 3 space separated numbers representing the cost of 
   painting nth house with red or blue or green color.
   
3. You are required to calculate and print the minimum cost of painting all houses without 
    painting any consecutive house with same color.
    
4
1 5 7
5 8 4
3 2 9
1 2 4
8

*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[][] = new int[n][3];
		 for(int i = 0; i < arr.length; i++) {
			 for(int j = 0; j < arr[0].length; j++) {
				 arr[i][j] = sc.nextInt();
			 }
		 }
		 
		 long dp[][] = new long[n][3];
		 
		 dp[0][0] = arr[0][0]; /** red  */
		 dp[0][1] = arr[0][1]; /** blue */
		 dp[0][2] = arr[0][2]; /** green */
		/** Put the values present at row index 0 1 and 2 in arr, in dp matrix at 0th row */ 
		 
		 for(int row = 1; row < arr.length; row++) {
			 dp[row][0] = arr[row][0] + Math.min(dp[row - 1][1], dp[row - 1][2]);
			 dp[row][1] = arr[row][1] + Math.min(dp[row - 1][0], dp[row - 1][2]);
			 dp[row][2] = arr[row][2] + Math.min(dp[row - 1][0], dp[row - 1][1]);
			 
		 }
		 long ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
		 System.out.println(ans);
		 
		
	}
     
}
