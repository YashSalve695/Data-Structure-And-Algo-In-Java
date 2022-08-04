package Graph;

import java.io.*;
import java.util.*;

public class AsFarFromLandAsPossible {
	
	/**
	 
	 Given an n*n grid containing only values 0 and 1, where 0 represents water and 1 represents 
	 land, find a water cell such that its distance to the nearest land cell is maximized, 
	 and return the distance. If no land or water exists in the grid, return -1.

     The distance used in this problem is the Manhattan distance: 
     the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
	 
	 */
	
	/**
	 
	 * TIME = O(V + E) --( MULTISTORE BFS)
	 * SPACE = O(V) --> QUEUE SPACE
	
	 */
	
	 public static class Pair {
		 
		 int row_index;
		 int col_index;
		 
		 Pair(int row_index, int col_index){
			 
			 this.row_index = row_index;
			 this.col_index = col_index;
		 }
	 }
	                    //  R  C
	 static int[][] dir = {{0, 1}, // right direction 
			               {1, 0}, // bottom direction
			               {0, -1}, // left direction
			               {-1, 0}}; // up direction
	 
	 public static int maxDistance(int[][] grid) {
       
		 LinkedList<Pair> queue = new LinkedList<>();
		 
		  for(int row = 0; row < grid.length; row++) {
			  for(int col = 0; col < grid[0].length; col++) {
				  int val = grid[row][col];
				  
				  if(val == 1) {
					  queue.addLast(new Pair(row, col));
	/** put all the indexes of 1 in the queue */				  
				  }
			  }
		  }
   /** Edge case --> 1. If the grid contains all 0.		  
                     2. And grid contains all the 1, so return -1 */
		  if(queue.size() == 0 || queue.size() == grid.length * grid[0].length) {
			  return -1;
		  }
		  
		  int level = -1; /** current level is -1 */
		  
		  while(queue.size() > 0) {
			  level++; /** increase the level, so it will tell us 
			                max distance , which we will return */
			  
			  int size = queue.size();
			  
			  while(size-- > 0) {
				  
				  Pair remove = queue.removeFirst();
		/** Remove first pair from the queue */		  
				  
				  for(int i = 0; i < 4; i++) {
		/** Now, see all the dir of that pair */			  
					  
					  int row_lvl = remove.row_index + dir[i][0];
					  int col_lvl = remove.col_index + dir[i][1];
					  
					  
			  if(row_lvl < 0 || col_lvl < 0 || row_lvl >= grid.length ||
			     col_lvl >= grid[0].length || grid[row_lvl][col_lvl] == 1) {
				  continue;  
			  }
				
			  queue.addLast(new Pair(row_lvl, col_lvl));
			     grid[row_lvl][col_lvl] = 1;
				  }
			  }
		  }
		  return level;
	  }

	public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(br.readLine());
	    int[][] arr = new int[n][n];

	    for (int i = 0; i < n; i++) {
	      String[] st = br.readLine().split(" ");
	      for (int j = 0; j < n; j++) {
	        arr[i][j] = Integer.parseInt(st[j]);
	      }
	    }

	    System.out.println(maxDistance(arr));

	  }

	 
	}



/** 
 
3
0 0 0
0 1 1
1 1 1

Output
2
  
 * */
