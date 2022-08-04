package DynamicProgramming;

import java.util.*;

import Datatypes.introduction;

public class PaintHouseManyColours {
	
/**

1. You are given a number n and a number k separated by a space, representing the number of 
   houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of 
   painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without 
   painting any consecutive house with same color.

4 3
1 5 7
5 8 4
3 2 9
1 2 4

8

*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int house = sc.nextInt();
		int colour = sc.nextInt();
		
		int arr[][] = new int[house][colour];
		 for(int i = 0; i < arr.length; i++) {
			 for(int j = 0; j < arr[0].length; j++) {
				 arr[i][j] = sc.nextInt();
			 }
		 }
		                    /**row*/ /**col*/
		 int dp[][] = new int[arr.length][arr[0].length];
		 
		 int least = Integer.MAX_VALUE;
		 int second_least = Integer.MAX_VALUE;
		/** Take out least and secleast from each row */
		 
		 for(int col = 0; col < dp[0].length; col++) {
			 dp[0][col] = arr[0][col];
			 
			 if(arr[0][col] <= least) {
				 second_least = least;
				 least = arr[0][col];
				 
			 } else if(arr[0][col] <= second_least) {
				 second_least = arr[0][col];
			 }
		 }
		 
//		 int new_least = Integer.MAX_VALUE;
//		 int new_second_least = Integer.MAX_VALUE;
//		 
		 for(int row = 1; row < dp.length; row++) {
			 int new_least = Integer.MAX_VALUE;
			 int new_second_least = Integer.MAX_VALUE;
			 
			 for(int col = 0; col < dp[0].length; col++) {
				 if(least == dp[row - 1][col]) {
					 dp[row][col] = second_least + arr[row][col];
				 } else {
					 dp[row][col] = least + arr[row][col];
				 }
				 
				 if(dp[row][col] <= new_least) {
					 new_second_least = new_least;
					 new_least = dp[row][col];
				 
				 } else if(dp[row][col] <= new_second_least) {
					 new_second_least = dp[row][col];
				 }
			 }
			 /** Update least and second least*/
			 least = new_least;
			 second_least = new_second_least;
		 }
		 System.out.println(least);
	}

}
