package DynamicProgramming;

import java.util.*;

public class LongestPalindromicSubstring {
	
	/**
	
Given a string s, return the longest palindromic substring in s.

babad
bab
	
cbbd
bb	
	
	*/
  public static String longestPalindrome(String s) {
        
        String len = "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        
        for(int g = 0; g < s.length(); g++){
            
            for(int row = 0,col = g; col < dp.length; row++,col++){
                
                if(g == 0){
                    dp[row][col] = true;
                    
                } else if(g == 1){
                    if(s.charAt(row) == s.charAt(col)){
                    dp[row][col] = true;
                    } else {
                     dp[row][col] = false;   
                    }
                    
                } else {
                    if(s.charAt(row) == s.charAt(col) && dp[row + 1][col - 1] == true){
                        dp[row][col] = true;
                        
                    } else {
                        dp[row][col] = false;
                    }
                }
                if(dp[row][col]){
                    len = s.substring(row, col + 1);
                }
            }
        }
        
        return len;
    }
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		String ans = longestPalindrome(s);
		 System.out.println(ans);

	}

}
