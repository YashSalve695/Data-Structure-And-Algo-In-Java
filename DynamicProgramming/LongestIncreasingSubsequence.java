package DynamicProgramming;

import java.util.*;

public class LongestIncreasingSubsequence {
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private static int LIS(int arr[]) {
		
		
		int overall_max = 0;
		int dp[] = new int[arr.length];
		
		
		for(int i = 0; i < dp.length; i++) {
			int max = 0;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
				  if(dp[j] > max) {
					  max = dp[j];
				  }	
				}
			}
			dp[i] = max + 1;
			if(dp[i] > overall_max) {
				overall_max = dp[i];
			}
		}
		//print(dp);
		return overall_max;
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
      int res = LIS(arr);
       System.out.println(res);
	}

}
