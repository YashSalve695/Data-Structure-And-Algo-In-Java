package DynamicProgramming;

import java.util.*;

public class MinDeletionToMakePalindrome {
	
	public static int Min_Deletions(String str) {
		
		int dp[][] = new int[str.length()][str.length()];
		
		for(int gap = 0; gap < str.length(); gap++) {
			for(int row = 0, col = gap; col < dp.length; row++, col++) {
				
				if(gap == 0) {
					dp[row][col] = 1;
					
				} else if(gap == 1) {
					dp[row][col] = str.charAt(row) == str.charAt(col) ? 2 : 1;
					
				} else {
					
					if(str.charAt(row) == str.charAt(col)) {
						dp[row][col] = dp[row + 1][col - 1] + 2;
					} else {
						dp[row][col] = Math.max(dp[row + 1][col], dp[col - 1][row]);
					}
				}
				
			}
		}
		
		int ans = str.length() - dp[0][dp.length - 1];
		return ans;
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		
		String s = sc.next();
//		int dp[][] = new int[n][n];
		
		int res = Min_Deletions(s);
		System.out.println(res);

	}

}
