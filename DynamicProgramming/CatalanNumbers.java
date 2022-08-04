package DynamicProgramming;

import java.util.*;

public class CatalanNumbers {
	
	
	/**
	
1. You are given a number n.
2. You are required to find the value of nth catalan number.
C0 -> 1
C1 -> 1
C2 -> 2
C3 -> 5
..
Cn -> C0.Cn-1 + C1.Cn-2 + .. + Cn-2.C1 + Cn-1.C0

4
14
	
	*/
	public static int FindCatalan(int n) {
		
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i < dp.length; i++) {
			for(int j = 0; j < i; j++) {
				
				dp[i] += dp[j] * dp[i - j - 1]; /** catalan formula */
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int res = FindCatalan(n);
		 System.out.println(res);
		

	}

}
