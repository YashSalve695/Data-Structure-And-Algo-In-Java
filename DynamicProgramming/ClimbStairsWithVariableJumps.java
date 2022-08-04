package DynamicProgramming;

import java.util.*;

public class ClimbStairsWithVariableJumps {

//	private static int Climb_with_variable_jumps(int arr[]) {
//		
//		int n = arr.length;
//		
//		int dp[] = new int[n + 1];
//		dp[n] = 1;
//		
//		for(int fill = n - 1; fill >= 0; fill--) {
//			for(int step = 1; step <= arr[fill] && fill + step < dp.length; fill++) {
//				dp[fill] += dp[fill + step];
//			}
//		}
//		return dp[0];
//	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int steps[] = new int[n];
		 for(int i = 0; i < steps.length; i++) {
			 steps[i] = sc.nextInt();
		 }
		 
		int dp[] = new int[n + 1];
		dp[n] = 1;
		/**Make dp array of n + 1, At n there is always one route that don,t walk */
		
		for(int fill = n - 1; fill >= 0; fill--) {
		/** This loop will help us to fill the steps in dp array */	
			for(int step = 1; step <= steps[fill] && fill + step < dp.length; step++) {
		/** This loop will help us to count the steps */		
				dp[fill] += dp[fill + step];
		/** It will add current count in dp and step array */		
			}
		}
		System.out.println(dp[0]);
	    /** At 0th index we will get the total number of steps that will required to reach the des */	
	}

}

/**
 
10
3
3
0
2
1
2
4
2
0
0 
  
5  
  
 * */
