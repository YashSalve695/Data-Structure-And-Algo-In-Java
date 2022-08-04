package DynamicProgramming;

import java.util.*;
import java.io.*;

public class PathsOf01KnapSack {
	
	/**

1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
5. Also, you have to print the indices of items that should be selected to make maximum profit.
6. You have to print all such configurations.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.

5
15 14 10 45 30
2 5 1 3 4
7

75
3 4 

*/
	
	public static class Pair {
		
		int row;
		int col;
		String psf;
		
		Pair(int row, int col, String psf){
			this.row = row;
			this.col = col;
			this.psf = psf;
		}
	}
	
	 public static void main(String[] args) throws Exception {
		 
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());

	        int[] values = new int[n];
	        String str1 = br.readLine();
	        for (int i = 0; i < n; i++) {
	            values[i] = Integer.parseInt(str1.split(" ")[i]);
	        }

	        int[] wts = new int[n];
	        String str2 = br.readLine();
	        for (int i = 0; i < n; i++) {
	            wts[i] = Integer.parseInt(str2.split(" ")[i]);
	        }

	        int cap = Integer.parseInt(br.readLine());

	       
	        
	        int dp[][] = new int[values.length + 1][cap + 1];
	           
	           for(int row_index = 1; row_index < dp.length; row_index++) {
	        	    for(int col_index = 1; col_index < dp[0].length; col_index++) {
	        		   
	        		   dp[row_index][col_index] = dp[row_index - 1][col_index];
	        		   
	        		   if(col_index >= wts[row_index - 1]) {
	        			   if(dp[row_index - 1][col_index - wts[row_index - 1]] + 
	        					      values[row_index - 1] > dp[row_index - 1][col_index]) {
	        				   
	         dp[row_index][col_index] = dp[row_index - 1][col_index - wts[row_index - 1]] + 
	        		                     values[row_index - 1];
	        			   }
	        		   }
	        	   }
	           }
	        int ans = dp[values.length][cap];
	         System.out.println(ans);
	         
	         ArrayDeque<Pair> queue = new ArrayDeque<>();
	         queue.add(new Pair(values.length, cap, ""));
	         
	         
	    }
	}