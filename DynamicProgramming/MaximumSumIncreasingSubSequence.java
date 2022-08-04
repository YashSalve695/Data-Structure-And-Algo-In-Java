package DynamicProgramming;

import java.util.*;

/**

10
10 22 9 33 21 50 41 60 80 3
255


*/
public class MaximumSumIncreasingSubSequence {
	
	private static int Max(int arr[]) {
		
		int overall_max = Integer.MIN_VALUE;
		
		int dp[] = new int[arr.length];
		
		 for(int i = 0; i < dp.length; i++) {
			 Integer max = null;
			 
			 for(int j = 0; j < i; j++) {
				 if(arr[j] <= arr[i]) {
					 if(max == null) {
						 max = dp[j];
						 
					 } else if(dp[j] > max) {
						 max = dp[j];
					 }
				 }
			 }
			 
			 if(max == null) { /** for first element in the arr */ 
				 dp[i] = arr[i];
			 } else {
				 dp[i] = max + arr[i];
			 }
			 
			 if(dp[i] > overall_max) {
				 overall_max = dp[i];
			 }
		 }
	
		return overall_max;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
      
		int res = Max(arr);
		 System.out.println(res);
		
	}

}
