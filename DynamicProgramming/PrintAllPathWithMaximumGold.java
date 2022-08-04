package DynamicProgramming;

import java.util.*;
import java.io.*;

public class PrintAllPathWithMaximumGold {
	
	/**

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
8. Also, you have to print all paths with maximum gold.


6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

33
4 d3 d1 d2 d3 d1 

*/
	 private static class Pair {
	      String psf;
	      int row;
	      int col;

	      public Pair(String psf, int row, int col) {
	         this.psf = psf;
	         this.row = row;
	         this.col = col;
	      }
	   }
	 
	 private static void Max_Gold_path(int arr[][]) {
		 
		 ArrayDeque<Pair> queue = new ArrayDeque<>();
		 
		 for(int row = 0; row < arr.length; row++) {
			 if(arr[row][0] == max) {
				 queue.add(new Pair(" ", row, 0));
			 }
		 }
		 
		 while(queue.size() > 0) {
			 
			 Pair remove = queue.removeFirst();
			 
			 if(remove.col == arr[0].length - 1) {
				 System.out.println(remove.psf);
				 
			 } else if(remove.row == 0) {
				 int zero_max = Math.max(arr[remove.row][remove.col + 1], 
						                 arr[remove.row + 1][remove.col + 1]);
				 
				 if(zero_max == arr[remove.row][remove.col + 1]) {
					 queue.add(new Pair(remove.psf + " d2", remove.row, remove.col + 1));
				 }
				 
				 if(zero_max == arr[remove.row + 1][remove.col + 1]) {
					 queue.add(new Pair(remove.psf + " d3", remove.row + 1, remove.col + 1));
				 }
				 
			 } else if(remove.row == arr.length - 1) {
				 int last_max = Math.max(arr[remove.row][remove.col + 1],
						                 arr[remove.row - 1][remove.col + 1]);
				 
				 if(last_max == arr[remove.row][remove.col + 1]) {
					 queue.add(new Pair(remove.psf + " d2", remove.row, remove.col + 1));
				 }
				 
				 if(last_max == arr[remove.row - 1][remove.col + 1]) {
					 queue.add(new Pair(remove.psf + " d1", remove.row - 1, remove.col + 1));
				 }
			 } else {
				 
				 int mid_max = Math.max(arr[remove.row][remove.col + 1],/** vertical check*/
						       Math.max(arr[remove.row + 1][remove.col + 1],/** up dia check*/ 
						    		    arr[remove.row - 1][remove.col + 1]));/** down dia check*/
				 
				 if(mid_max == arr[remove.row][remove.col + 1]) {
					 queue.add(new Pair(remove.psf + " d2", remove.row, remove.col + 1));
				 }
				 
				 if(mid_max == arr[remove.row + 1][remove.col + 1]) {
					 queue.add(new Pair(remove.psf + " d3", remove.row + 1, remove.col + 1));
				 }
				 
				 if(mid_max == arr[remove.row - 1][remove.col + 1]) {
					 queue.add(new Pair(remove.psf + " d1", remove.row - 1, remove.col + 1));
				 }
			 }
		 }
		 
	 }
	 
	   static int max;
	   public static void main(String[] args) throws Exception {
		   
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int n = Integer.parseInt(br.readLine());
	      int m = Integer.parseInt(br.readLine());
	      int[][] arr = new int[n][m];

	      for (int i = 0; i < n; i++) {
	         String str = br.readLine();
	         for (int j = 0; j < m; j++) {
	            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
	         }
	      }

	      int dp[][] = new int[arr.length][arr[0].length];
	      
	      for(int col = arr[0].length - 1; col >= 0; col--) {
	    	  for(int row = arr.length - 1; row >= 0; row--) {
	    		  
	    		  if(col == arr[0].length - 1) {
	    			  dp[row][col] = arr[row][col];
	    			  
	    		  } else if(row == 0) {
	    			  dp[row][col] = Math.max(dp[row][col + 1], dp[row + 1][col + 1]);
	    			  
	    		  } else if(row == arr.length - 1) {
	    			  dp[row][col] = Math.max(dp[row][col + 1], dp[row - 1][col + 1]);
	    			  
	    		  } else {
	    			  
	    			  dp[row][col] = Math.max(dp[row][col + 1], 
	    					         Math.max(dp[row + 1][col + 1], dp[row - 1][col + 1]));
	    		  }
	    	  }
	      }
	       max = Integer.MIN_VALUE;
	       
	       for(int i = 0; i < dp.length; i++) {
	    	   if(dp[i][0] > max) {
	    		   max = dp[i][0];
	    	   }
	       }
	     
	       System.out.println(max);
	       Max_Gold_path(dp);
	   }
	   
	}