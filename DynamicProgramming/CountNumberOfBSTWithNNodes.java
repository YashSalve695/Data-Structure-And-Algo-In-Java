package DynamicProgramming;

import java.util.*;

public class CountNumberOfBSTWithNNodes {
	
	/**
	
1. You are given a number n, representing the number of elements.
2. You are required to find the number of Binary Search Trees you can create using the elements.	
	
	*/
	/** n is no of nodes */
	private static int Count_Nodes(int n) {
		
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			
			int left_side = 0;
			int right_side = i - 1;
			
			while(left_side <= i - 1) {
				
				dp[i] += dp[left_side] * dp[right_side];
				
				left_side++;
				right_side--;
				
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int res = Count_Nodes(n);
		 System.out.println(res);

	}

}
