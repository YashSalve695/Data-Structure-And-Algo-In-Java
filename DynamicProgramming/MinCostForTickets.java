package DynamicProgramming;

import java.util.*;

public class MinCostForTickets {
	
	
	/**

1. You are going on a vacation for a year, you've decided certain days for travelling in the city, 
   given to you as a strictly increasing array from day 1....365
 2. There are 3 kinds of passes you can take in this city for transport: 
     a) A single day pass, cost of which is in an array at cost[0]
     b) A week's pass, cost of which  is in an array at cost[1]
     c) A month's pass, cost of which  is in an array at cost[2]
     
 3. Find and return minimum amount it'll cost you for travelling in the city 
    according to the given days
    
 4. Input and output is handled for you
 
 5. It is a functional problem ,please do not modify main()

9
2 3 8 9 10 11 12 14 27
1 5 25

8

*/
	 public static void main(String[] args) {
 	 	
         Scanner scn= new Scanner(System.in);
         int n=scn.nextInt();
         int[] days= new int[n];
         for(int i=0;i<n;i++){
             days[i]=scn.nextInt();
         }
         int[] costs = new int[3];
         for(int i = 0;i < 3;i++){
             costs[i]=scn.nextInt();
 	 	 }
 	 	 Arrays.sort(days);
         System.out.println(mincostTickets(days, costs));
 	 }
 	
	 public static boolean willtraveltoday(int curr_day, int days[]) {
		 
		 for(int i = 0; i < days.length; i++) {
			 if(curr_day == days[i]) {
				 return true;
			 } 
			 }
			 
		 return false;
		 }
	 
      // RECURSIVE
	 public static int recur(int curr_day, int costs[], int days[]) {
		 
		 if(curr_day > days[days.length - 1]) return 0;
		 
		 int ans = (int)1e8;
		 
		  if(willtraveltoday(curr_day, days)) {
			  
			  ans = recur(curr_day + 1, costs, days) + costs[0];
			  /** daily travel cost*/
			  
			  ans = Math.min(ans, recur(curr_day + 7, costs, days) + costs[1]);
			  /** weekly travel cost*/
			  
			  /** monthly travel cost*/
			  ans = Math.min(ans, recur(curr_day + 30, costs, days) + costs[2]);
			  
		  } else {
			  
			  return recur(curr_day + 1, costs, days);
		  }
		 return ans;
	 }
	 
	   /** MEMOZIATION */
	  public static int Memo(int curr_day, int costs[], int days[], int dp[]) {
		  
		  if(curr_day > days[days.length - 1]) {
			  return dp[curr_day] = 0;
		  }
            /**if currday is as at end day then return 0 */
		  
		  if(dp[curr_day] != -1) {
			  return dp[curr_day];
		  }
		  /** If ans of that is calculated previously than return that day */
		  
		  int ans = Integer.MAX_VALUE;
		  
		  if(willtraveltoday(curr_day, days)) {
			  
			  ans = Memo(curr_day + 1, costs, days, dp) + costs[0];
			  
			  ans = Math.min(ans, Memo(curr_day + 7, costs, days, dp) + costs[1]);
			  
			  ans = Math.min(ans, Memo(curr_day + 30, costs, days, dp) + costs[2]);
			  
 		  } else {
 			   return dp[curr_day] = Memo(curr_day + 1, costs, days, dp);
 		  }
		  return dp[curr_day] = ans;
	  }
	  
	  /** TABULATION*/
	 public static int Tabulate(int cost[], int days[]) {
		 
		 int dp[] = new int[400];
		 
		  for(int curr_day = 399; curr_day >= 0; curr_day--) {
			  if(curr_day > days[days.length - 1]) {
				  dp[curr_day] = 0;
				  continue;
			  }
		  
			  
			  int ans = Integer.MAX_VALUE;
			  
			  if(willtraveltoday(curr_day, days)) {
				  
				  ans = dp[curr_day + 1] + cost[0];
			  
				  ans = Math.min(dp[curr_day + 7] + cost[1], ans);
				  
				  ans = Math.min(dp[curr_day + 30] + cost[2], ans);
				  
			  } else {
				  dp[curr_day] = dp[curr_day + 1];
			  }
			  
			  dp[curr_day] = ans;
		  }
		  return dp[1];
}

	  
 
 	 public static int mincostTickets(int[] days, int[] costs) {
 	 	
 		 int dp[] = new int[400];
 		 Arrays.fill(dp, -1);
 		 
 		 return Tabulate(costs, days);
 		 
 	 }
 }