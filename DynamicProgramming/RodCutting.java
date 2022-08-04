package DynamicProgramming;

import java.util.*;

public class RodCutting {
	
	
	/**
	
1. You are given an integer N, which represents the length of a rod, and an array of integers, 
   which represents the prices of rod pieces of length varying from 1 to N.
2. You have to find the maximum value that can be obtained by selling the rod.
3. You can sell it in pieces or as a whole.
	
8
1   
5   
8   
9  
10 
17  
17  
20	

22
	
	
	*/
	private static int Max_profit(int prices[]) {
		
		int newprices[] = new int[prices.length + 1];
		
		for(int i = 0; i < prices.length; i++) {
			newprices[i + 1] = prices[i];
		}
		
		int dp[] = new int[newprices.length];
		dp[0] = 0;
		dp[1] = newprices[1];
		
		for(int i = 2; i < dp.length; i++) {
			dp[i] = newprices[i];
			
			int left = 1;
			int right = i - 1;
			
			while(left <= right) {
				if(dp[left] + dp[right] > dp[i]) {
					dp[i] = dp[left] + dp[right];
				}
				left++;
				right--;
			}
		}
		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		
		 int res = Max_profit(arr);
		  System.out.println(res);
	}

}
