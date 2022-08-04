package DynamicProgramming;

import java.util.*;

/**

1. You are given two strings S1 and S2.
2. You have to make these two strings equal by deleting characters. 
   You can delete characters from any of the two strings.
3. The cost of deleting a character from any string is the ASCII value of that character.
4. You have to find the minimum ASCII sum of deleted characters.


sea
eat

231

*/

public class MinimumASCIIDelete {
	
	public static int get(String s, int indx) {
		
		int sum = 0;
		
		for(int i = 0; i < s.length(); i++) {
			sum += s.charAt(i);
		}
		return sum;
	}

	public static int Min_Delete(String s1, String s2, int N, int M, int dp[][]) {
		
		for(int n = 0; n <= N; n++) {
			for(int m = 0; m <= M; m++) {
				
				if(m == 0) {
					int charsum = get(s1, n);
					dp[n][m] = charsum;
					
				} else if(n == 0) {
					dp[n][m] = get(s2, m);
				}
				
				else if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
					dp[n][m] = Min_Delete(s1, s2, n - 1, m - 1, dp);
					
				} else {
					
					int ans1 = s1.charAt(n - 1) + dp[N - 1][M];
					int ans2 = s2.charAt(m - 1) + dp[N][M - 1];
					
					return dp[n][m] = Math.min(ans1, ans2);
				}
			}
		}
		
       
		
		return dp[N][M];
	}
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		System.out.println(Min_Delete(s1, s2, 0, 0, dp));
	}

}
