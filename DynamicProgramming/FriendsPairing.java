package DynamicProgramming;

import java.util.*;

public class FriendsPairing {
	
	
	/**

1. You are given a number n, representing the number of friends.
2. Each friend can stay single or pair up with any of it's friends.
3. You are required to print the number of ways in which these friends can stay single or pair up.
E.g.
1 person can stay single or pair up in 1 way.
2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.\

4
10

   */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		int friends = sc.nextInt();
		
		int dp[] = new int[friends + 1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int frd = 3; frd <= friends; frd++) {
			dp[frd] = dp[frd - 1] + dp[frd - 2] * (frd - 1);
		}
		
   System.out.println(dp[friends]);
	}

}
