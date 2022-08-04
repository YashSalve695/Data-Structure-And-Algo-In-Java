package DynamicProgramming;

import java.util.*;

public class EggDrop {
	
/**	
	
1. You are given two integers N and K. N represents the number of eggs and K represents the number of floors in a building.
2. You have to find the minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy.
3. The critical floor is defined as the lowest floor from which you drop an egg and it doesn't break. 
4. There are certain which you have to follow -
   a. All eggs are identical.
   b. An egg that survives a fall can be used again.
   c. A broken egg can't be used again.
   d. If the egg doesn't break at a certain floor, it will not break at any floor below.
   e. If the egg breaks at a certain floor, it will break at any floor above.	
	
3
10
	
4
	
	*/

	
	public static int Egg_drop(int n, int k) {
		
		int dp[][] = new int[n + 1][k + 1];
		
		 for(int row = 1; row <= n; row++) {
			 for(int col = 1; col <= k; col++) {
				 
				 if(row == 1) {
					 dp[row][col] = col;
					 
				 } else if(col == 1) {
					 dp[row][col] = 1;
					 
				 } else {
					 int min = Integer.MAX_VALUE;
					 
					 for(int mj = col - 1,pj = 0; mj >= 0 ; mj--,pj++) {
						 
						 int v1 = dp[row][mj]; // survive
						 int v2 = dp[row - 1][pj]; // break
						 
						 int max = Math.max(v1, v2);
						 min = Math.min(max, min);
					 }
					 dp[row][col] = min + 1;
				 }
			 }
		 }
		 return dp[n][k];
	}
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	int egg = sc.nextInt();
	int floor = sc.nextInt();
	
	int ans = Egg_drop(egg, floor);
	 System.out.println(ans);

	}

}
