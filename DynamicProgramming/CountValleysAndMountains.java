package DynamicProgramming;

import java.util.*;

public class CountValleysAndMountains {
	
	
	/**
	
1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
2. You are required to find the number of valleys and mountains you can create using strokes.
E.g.



Note -> At no point should we go below the sea-level. (number of downstrokes should never be more than number of upstrokes).
	
	*/
	private static int Count_val_and_moun(int n) {
		
		
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i < dp.length; i++) {
			
			int inside = i - 1;
			int outside = 0;
			
			while(inside >= 0) {
				
				dp[i] += dp[outside] * dp[inside];
				
				inside--;
				outside++;
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int res = Count_val_and_moun(n);
		 System.out.println(res);
		

	}

}
