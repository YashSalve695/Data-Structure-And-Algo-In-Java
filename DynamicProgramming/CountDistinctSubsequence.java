package DynamicProgramming;

import java.util.*;

/**

Given a string s, return the number of distinct non-empty subsequences of s. 
Since the answer may be very large, return it modulo 109 + 7.

A subsequence of a string is a new string that is formed from the original string by deleting 
some (can be none) of the characters without disturbing the relative positions of the remaining 
characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.

abc
7

aba
6

 */


public class CountDistinctSubsequence {
	
	public static int distinctSubseqII(String s) {
        long mod = (long) Math.pow(10,9)+7;
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=1;i<dp.length;i++){
            dp[i] = ((long)dp[i-1]*2)%mod;
            
            char c = s.charAt(i-1);
            if(map.containsKey(c)){
                int j = map.get(c);
                dp[i] =  dp[i] - dp[j-1];
            }
            map.put(c, i);
            if(dp[i]<0) dp[i]+=mod;
            dp[i]%=mod;
        }
        return (int) dp[s.length()]-1;
    }
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int res = distinctSubseqII(s);
		System.out.println(res);

	}

}
