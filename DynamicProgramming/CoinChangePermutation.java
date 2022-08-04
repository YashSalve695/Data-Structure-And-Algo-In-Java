 package DynamicProgramming;

import java.util.*;

public class CoinChangePermutation {
	
	private static int Coin_Permute(int coins[], int target) {
		
		int dp[] = new int[target + 1];
		dp[0] = 1;
		
		for(int amt = 1; amt <= target; amt++) {
			for(int coin : coins) {
				if(coin <= amt) {
					int rem_amt = amt - coin;
					dp[amt] += dp[rem_amt];
				}
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int coins[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 coins[i] = sc.nextInt();
		 }
		 int target = sc.nextInt();
		 
		 int res = Coin_Permute(coins, target);
		 System.out.println(res);
		

	}

}
