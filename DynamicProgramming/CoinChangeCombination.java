package DynamicProgramming;

import java.util.*;

public class CoinChangeCombination {
	
	 public static int change(int amount, int[] coins) {
	        
	        int dp[] = new int[amount + 1];
	        /** Make dp array of n + 1 len */
	        dp[0] = 1;
	        /** There is always 1 combination  at 0*/
	        
	        for(int i = 0; i < coins.length; i++){
	        /** This loop will iterate on coins array */ 	
	            for(int jumps = coins[i]; jumps < dp.length; jumps++){
	        /** This loop will iterate on dp array, and will start from 
	            value present in the coins array */    	
	                dp[jumps] += dp[jumps - coins[i]];
	        /** And store the combination count, on dp array */        
	            }
	        }
	        return dp[amount];
	    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int coins[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 coins[i] = sc.nextInt();
		 }
		 
		 int amt = sc.nextInt();
		 
		 int res =  change(amt, coins);
		  System.out.println(res);
		
	}

}
