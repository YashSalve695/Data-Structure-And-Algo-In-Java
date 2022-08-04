package DynamicProgramming;

import java.util.*;

public class ClimbStairWithMinMoves {

	public static void main(String[] args) {
		
	 Scanner sc = new Scanner(System.in);
	 int n = sc.nextInt();
	 
	 int arr[] = new int[n + 1];
	  for(int i = 0; i < n; i++) {
		  arr[i] = sc.nextInt();
	  }
	  
	  Integer dp[] = new Integer[n + 1];
	  /** Initially there is null present at each index */
	  dp[n] = 0;
	  /** At n there is 0 moves initially */
	  
	  for(int i = n - 1; i >= 0; i--) {
		  int min = Integer.MAX_VALUE;
		  /** min holding the big number*/
		  
		  int val = arr[i]; /** steps*/
		  if(val > 0) { /** If null is not present than work else not */
			  
			  for(int j = 1; j <= val && i + j < dp.length; j++) {
		/** this loop will get till all the steps and also check out off bounds case(Imp) */		  
				  if(dp[i + j] != null) {
					  min = Math.min(min, dp[i + j]);
		/** if at dp array null is present dont work else work 
		    and take out min from it */			  
				  }
			  }
			  
			  if(min != Integer.MAX_VALUE) {
				  dp[i] = min + 1;
		/** Edge case : if min value is not maxValue , then add min + 1 in dp arr at that index*/		  
			  }
		  }
	  }
  System.out.println(dp[0]);
	}

}



/**
 
10
3
3
0
2
1
2
4
2
0
0
 
4
 * */
