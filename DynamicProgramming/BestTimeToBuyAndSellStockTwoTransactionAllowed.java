package DynamicProgramming;

import java.util.*;

public class BestTimeToBuyAndSellStockTwoTransactionAllowed {
	
	/**
	
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two 
   transactions at-most.

Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).	
	
9

11
6
7
19
4
1
6
18
4

30
	
	
	
	*/
	private static int maxProfit(int prices[]) {
		
		int max_profit_if_sell_today = 0;
		int least_so_far = prices[0];
		
		int dp1[] = new int[prices.length];
		
		for(int of_that_day = 1; of_that_day < prices.length; of_that_day++) {
			 if(prices[of_that_day] < least_so_far) {
				 least_so_far = prices[of_that_day];
			 }
			 
			 max_profit_if_sell_today = prices[of_that_day] - least_so_far;
			   if(max_profit_if_sell_today > dp1[of_that_day - 1]) {
				   dp1[of_that_day] = max_profit_if_sell_today;
				   
			   } else {
				   
				   dp1[of_that_day] = dp1[of_that_day - 1];
			   }
		}
		
		
		int max_profit_if_buy_today = 0;
		int max_after_today = prices[prices.length - 1];
		
		int dp2[] = new int[prices.length];
		
		for(int of_that_day = prices.length - 2; of_that_day >= 0; of_that_day--) {
			if(prices[of_that_day] > max_after_today) {
				max_after_today = prices[of_that_day];
			}
			
			max_profit_if_buy_today = max_after_today - prices[of_that_day];
			 if(max_profit_if_buy_today > dp2[of_that_day + 1]) {
				 dp2[of_that_day] = max_profit_if_buy_today;
				 
			 } else {
				 
				 dp2[of_that_day] = dp2[of_that_day + 1];
			 }
		}
		
		int overall_profit = 0;
		 for(int i = 0; i < prices.length; i++) {
			 if(dp1[i] + dp2[i] > overall_profit) {
				 overall_profit = dp1[i] + dp2[i];
			 }
		 }
		 return overall_profit;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		 
		 int res = maxProfit(arr);
		  System.out.println(res);
		
		

	}

}
