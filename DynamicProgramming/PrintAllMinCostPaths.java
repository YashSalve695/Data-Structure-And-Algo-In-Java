package DynamicProgramming;

import java.util.*;
import java.io.*;

public class PrintAllMinCostPaths {
	
	/**

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
7. You are required to traverse through the matrix and print the cost of the path which is least costly.
8. Also, you have to print all the paths with minimum cost.

6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

23
HVVHHVHVHV
HVVHHVHHVV

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
	 
	 private static void Get_Min_Paths(int arr[][]) {
		 
		 ArrayDeque<Pair> queue = new ArrayDeque<>();
		 queue.add(new Pair("", 0, 0));/** pair contains path, row index, col index*/
		 
		 while(queue.size() > 0) {
			 
			 Pair remove = queue.removeFirst();
			 
			 /** If we are destination print path*/ 
			 if(remove.row == arr.length - 1 && remove.col == arr[0].length - 1) {
				 System.out.println(remove.psf);
				 
			/** If we are at last row */	 
			 } else if(remove.row == arr.length - 1) {
				 queue.add(new Pair(remove.psf + "H", remove.row, remove.col + 1));
		    
		   /** If we are last col */		 
			 } else if(remove.col == arr[0].length - 1) {
				 queue.add(new Pair(remove.psf + "V", remove.row + 1, remove.col));
				 
			 } else {
				 
				 if(arr[remove.row][remove.col + 1] < arr[remove.row + 1][remove.col]) {
					 queue.add(new Pair(remove.psf + "H", remove.row, remove.col + 1));
					 
				 } else if(arr[remove.row][remove.col + 1] > arr[remove.row + 1][remove.col]) {
					 queue.add(new Pair(remove.psf + "V", remove.row + 1, remove.col));
					 
				 } else {
					 
					 queue.add(new Pair(remove.psf + "H", remove.row, remove.col + 1));
					 queue.add(new Pair(remove.psf + "V", remove.row + 1, remove.col));
				 }
			 }
		 }
		 
	 }

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
	      
	      for(int row = dp.length - 1; row >= 0; row--) {
	    	  for(int col = dp[0].length - 1; col >= 0; col--) {
	    		  
	    /** if row and col index is at end point so same value as it is present in arr */		  
	    		  if(row == dp.length - 1 && col == dp[0].length - 1) {
	    			  dp[row][col] = arr[row][col];
	    			  
	    /** If we are last row, just add values present in dp[col + 1] and value present in arr */ 			  
	    		  } else if(row == dp.length - 1) {
	    			  dp[row][col] = arr[row][col] + dp[row][col + 1]; 
	      			  
	     /** If we are last col, just add values presnt in dp[row + 1]*/
	    		  } else if(col == dp[0].length - 1) {
	    			  dp[row][col] = arr[row][col] + dp[row + 1][col];
	    			  
	    		  } else {
	    			  
	    			  dp[row][col] = arr[row][col] + Math.min(dp[row + 1][col], dp[row][col + 1]); 
	    		  }
	    	  }
	      }
	      System.out.println(dp[0][0]);
	      Get_Min_Paths(dp);
	   }

	}