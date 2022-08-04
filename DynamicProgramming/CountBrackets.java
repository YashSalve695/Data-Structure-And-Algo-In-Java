package DynamicProgramming;

import java.util.*;

public class CountBrackets {
	
	/**
	
1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
	
4
14	
	*/
	private static int Count_brackets(int n) {
		
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i < dp.length; i++) {
			
			int inside = i - 1;
			int outside = 0;
			
			while(inside >= 0) {
				
				dp[i] += dp[inside] * dp[outside];
				
				inside--;
				outside++;
			}
		}
		
		
		return dp[n];
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int res = Count_brackets(n);
		  System.out.println(res);

	}

}
