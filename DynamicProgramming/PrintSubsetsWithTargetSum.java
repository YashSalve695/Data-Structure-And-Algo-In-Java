package DynamicProgramming;

import java.util.*;
import java.io.*;

public class PrintSubsetsWithTargetSum {
	
	
	/**

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.
5. Also, you have to print the indices of elements that should be selected to achieve the given target.
6. You have to print all such configurations.

5
4
2
7
1
3
10

true
2 4 
1 2 3 
0 1 3 4 

*/
	 public static class Pair{
	        int row;
	        int col;
	        String psf;

	        public Pair(int row, int col, String psf){
	            this.row = row;
	            this.col = col;
	            this.psf = psf;
	        }
	    }
	 
//	 private static void Print_Subsets(boolean dparr[][], int n, int target) {
//		 
//		 ArrayDeque<Pair> queue = new ArrayDeque<>();
//		 queue.add(new Pair(n, target, ""));
//		 
//		 while(queue.size() > 0) {
//			 
//			 Pair remove = queue.removeFirst();
//			  
//			 if(remove.row == 0 && remove.col == 0) {
//				 System.out.println(remove.psf);
//			 } else {
//			 
//			 boolean exclude = dparr[remove.row - 1][remove.col];
//			 if(exclude) {
//				 queue.add(new Pair(remove.row - 1, remove.col, remove.psf));
//			 }
//			 
//			if(remove.col >= remove.row - 1) {
//				boolean include = dparr[remove.row - 1][remove.col - dparr[remove.row - 1]];
//				if(include) {
//					queue.add(new Pair(remove.row - 1, remove.col - dparr[remove.row - 1], remove.psf + (remove.row - 1)));
//				}
//			}
//			}
//		 }
//		 
//	 }
	 
	    public static void main(String[] args) throws Exception {
	    	
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());
	        int[] arr = new int[n];

	        for (int i = 0; i < n; i++) {
	            arr[i] = Integer.parseInt(br.readLine());
	        }

	        int tar = Integer.parseInt(br.readLine());
	        
	        
	        

	        boolean dp[][] = new boolean[arr.length + 1][tar + 1];
	        
	        for(int row_index = 0; row_index < dp.length; row_index++) {
	        	for(int col_index = 0; col_index < dp[0].length; col_index++) {
	        		
	        		if(col_index == 0) {
	        			dp[row_index][col_index] = true;
	        			
	        		} else if(row_index == 0) {
	        			dp[row_index][col_index] = false;
	        			
	        		} else {
	        			
	        	/** if up true is present than down is present */		
	        			if(dp[row_index - 1][col_index] == true) {
	        				dp[row_index][col_index] = true;
	        				
	        			} else if(col_index >= arr[row_index - 1]) {
	        				if(dp[row_index - 1][col_index - arr[row_index - 1]] == true) {
	        					dp[row_index][col_index] = true;
	        				}
	        			}
	        		}
	        	}
	        }
           System.out.println(dp[arr.length][tar]);
           
           /** BFS */
           ArrayDeque<Pair> queue = new ArrayDeque<>();
  		   queue.add(new Pair(n, tar, ""));
  		 
  		 while(queue.size() > 0) {
  			 
  			 Pair remove = queue.removeFirst();
  			  
  			 if(remove.row == 0 && remove.col == 0) {
  				 System.out.println(remove.psf);
  			 } else {
  			 
  			 boolean exclude = dp[remove.row - 1][remove.col];
  			 if(exclude) {
  				 queue.add(new Pair(remove.row - 1, remove.col, remove.psf));
  			 }
  			 
  			if(remove.col >= arr[remove.row - 1]) {
  				boolean include = dp[remove.row - 1][remove.col - arr[remove.row - 1]];
  				if(include) {
  					queue.add(new Pair(remove.row - 1, remove.col - arr[remove.row - 1], 
  							                          (remove.row - 1) + " " +remove.psf));
  				}
  			}
  			}
	    }
	    }
}


