package DynamicProgramming;

import java.util.*;

public class KnapSack01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int value[] = new int[n];
		int weights[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			value[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			weights[i] = sc.nextInt();
		}
		
		int capacity = sc.nextInt();
		
		
		/** Main code here */
		
		int dp[][] = new int[n + 1][capacity + 1];
		
		for(int row = 1; row < dp.length; row++) {
			for(int col = 1; col < dp[0].length; col++) {
				
				if(col >= weights[row - 1]) {
					int rem_cap = col - weights[row - 1];
				
					if(dp[row - 1][rem_cap] + value[row - 1] > dp[row - 1][col]) {
						dp[row][col] = dp[row - 1][rem_cap] + value[row - 1];
						
					} else {
						
						dp[row][col] = dp[row - 1][col];
					}
				} else {
					dp[row][col] = dp[row - 1][col];
				}
			}
		}
	 System.out.println(dp[n][capacity]);
	}

}
