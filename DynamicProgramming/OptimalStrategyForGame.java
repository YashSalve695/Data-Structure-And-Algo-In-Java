package DynamicProgramming;

import java.util.*;
/**

1. You are given an array(arr) of length N, where N is an even number.
2. The elements of the array represent N coins of values arr1,arr1...arrN.
3. You are playing a game against an opponent in an alternative way, where the opponent is equally smart.
4. In this game, a player selects either the first or the last coin from the row in every turn, removes it from the row permanently, and receives the value of the coin.
5. You have to find the maximum possible amount of money you can win if you make the first move.


4
5 3 7 10

15

*/

public class OptimalStrategyForGame {
	
	public static int optimal_strategy(int arr[]) {
		
		int dp[][] = new int[arr.length][arr.length];
		
		 for(int gap = 0; gap < dp.length; gap++) {
			 for(int row = 0,col = gap; col < dp.length; row++,col++) {
				 
				 if(gap == 0) {
					 dp[row][col] = arr[row];
					 
				 } else if(gap == 1) {
					 dp[row][col] = Math.max(arr[row], arr[col]);
					 
				 } else {
					 
					 int val1 = arr[row] + Math.min(dp[row + 2][col], dp[row + 1][col - 1]);
					 int val2 = arr[col] + Math.min(dp[row + 1][col - 1], dp[row][col - 2]);
					 
					 int val = Math.max(val1, val2);
					 dp[row][col] = val;
				 }
			 }
		 }
		
		return dp[0][arr.length - 1];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		 
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		
		 int ans = optimal_strategy(arr);
		  System.out.println(ans);

	}

}
