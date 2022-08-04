
package DynamicProgramming;

import java.util.*;

public class ClimbingStairs {
	
	/** */
	
	private static int count_paths(int n, int qb[]) { /** Memozition*/
		
		if(n == 0) {
			return 1;
   /** if n is equal to 0 than it is a valid path */	
			
		} else if(n < 0) {
			return 0;
  /** if the value of n is negative than that is invalid path */			
		}
		
		if(qb[n] > 0) {
			return qb[n];
  /** if the value in qb of n is present than return that value */			
		}
		
//		System.out.println("Hello" + n);
		int path1 = count_paths(n - 1, qb);
		int path2 = count_paths(n - 2, qb);
		int path3 = count_paths(n - 3, qb);
		
		int total_path = path1 + path2 + path3;
		
		qb[n] = total_path;
		/** Store that path in qb */
		
		return total_path;
	}
	
	public static int countpaths(int n) { /** Tabulation */
		
		int dp[] = new int[n + 1];
		dp[0] = 1;
		/** THERE IS ALWAYS ONE STEP AT ZERO STAIR THAT IS 1 */
		
		for(int index = 1; index <= n; index++) {
			
			if(index == 1) {
				dp[index] = dp[index - 1];
		/** if i is at 1st index, then it will go to 0th index only i - 2 and i - 3 is out of bound*/	
			/* EDGE CASE 1*/	
				
			} else if(index == 2) {
				dp[index] = dp[index - 1] + dp[index - 2];
		/** if i is at index 2, then it will go till 1 and 0th index and i - 3 is out of bound */		
		    /* EDGE CASE 2*/
				
			} else {
				dp[index] = dp[index - 1] + dp[index - 2] + dp[index - 3];
	   /** if above cases are false than go till n - 3 steps */			
			}
		}
		return dp[n];
	}
	
	/** TIME COMP = O(N)*/
	/** SPACE COMP = O(N)*/ 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int res = countpaths(n);
		System.out.println(res);

	}
}

