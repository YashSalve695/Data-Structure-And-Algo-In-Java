package DynamicProgramming;

import java.util.*;

public class StockBuyAndSellWithTranscFee {
	
	
	/**

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite 
   transactions, but has to pay "fee" for every closed transaction.
   
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
	 
12
10 15 17 20 16 18 22 20 22 20 23 25
3

13
	 
	 
	 */

	private static int Total_Profit(int prices[], int fee) {
		
		int buy_state_profit = -prices[0];
		int sell_state_profit = 0;
		
		for(int day = 1; day < prices.length; day++) {
			
			int new_buy_state_profit = 0;
			int new_sell_state_profit = 0;
			
			if(sell_state_profit - prices[day] > buy_state_profit) {
				new_buy_state_profit = sell_state_profit - prices[day];
				
			} else {
				
			   new_buy_state_profit = buy_state_profit;
			}
			
			if(buy_state_profit + prices[day] - fee > sell_state_profit) {
				new_sell_state_profit = buy_state_profit + prices[day] - fee;
				
			} else {
				
				new_sell_state_profit = sell_state_profit;
			}
			
			buy_state_profit = new_buy_state_profit;
			sell_state_profit = new_sell_state_profit;
		}
			return sell_state_profit;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int days = sc.nextInt();
		
		int prices[] = new int[days];
		for(int i = 0; i < prices.length; i++) {
			prices[i] = sc.nextInt();
		}
		int tran_fee = sc.nextInt();
		
		int ans = Total_Profit(prices, tran_fee);
		 System.out.println(ans);
	}

}
