package DynamicProgramming;

import java.util.*;

public class BestTimeToBuyAndSellStocks {
	
	
	/**

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single 
   transaction.	
   
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

17
	
	*/
	private static int Best_Time(int prices[]) {
		
		int least_so_far = Integer.MAX_VALUE;
		int overall_profit = 0;
		int profit_if_sell_today = 0;
		
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < least_so_far) {
				least_so_far = prices[i];
			}
			
			profit_if_sell_today = prices[i] - least_so_far;
			
			if(profit_if_sell_today > overall_profit) {
				overall_profit = profit_if_sell_today;
			}
		}
		return overall_profit;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int prices[] = new int[n];
		 for(int i = 0; i < prices.length; i++) {
			 prices[i] = sc.nextInt(); 
		 }
 	  int ans = Best_Time(prices);
 	   System.out.println(ans);
	}

}
