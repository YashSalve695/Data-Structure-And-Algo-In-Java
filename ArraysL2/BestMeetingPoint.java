package ArraysL2;

import java.util.*;

public class BestMeetingPoint {
	
	public static int minTotalDistance(int [][]grid) {
		
		// It will get all the x coordinates in the grid.
		ArrayList<Integer> xcordinate = new ArrayList<>();
		  for(int row = 0; row < grid.length; row++) {
			  for(int col = 0; col < grid[0].length; col++) {
				  if(grid[row][col] == 1) {
					  xcordinate.add(row);
				  }
			  }
		  }
		// It will get all the y coordinates in the grid.  
		ArrayList<Integer> ycordinate = new ArrayList<>();
		  for(int col = 0; col < grid[0].length; col++) {
			  for(int row = 0; row < grid.length; row++) {
				  if(grid[row][col] == 1) {
					  ycordinate.add(col);
				  }
			  }
		  }
	   // It will get the median in xcordinate.
		  int Medianx = xcordinate.get(xcordinate.size() / 2);
	   // It will get the median in ycordinate.	  
		  int Mediany = ycordinate.get(ycordinate.size() / 2);
		  
		  int distance = 0;
	  // It will gave us min distance of meeting,which
	  // will return at end.	  
		   
		   for(int xval : xcordinate) {// For each loop
			   distance += Math.abs(Medianx - xval);
	 // It will get each coordinates in the the x,
     // And substract it will median of x and each coordinates
	 // in x.And store it in ditance.		   
		   }
		   for(int yval : ycordinate) {
			   distance += Math.abs(Mediany - yval);
	 // It will get each coordinates in the the x,
     // And substract it will median of x and each coordinates
	 // in x.And store it in ditance.		   
		   }
		   return distance;
	// At the end return min total distance.	   
	}

	public static void main(String[] args) {

		
		 Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int m = scn.nextInt();


	        int[][] grid = new int[n][m];

	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < m; j++) {
	                grid[i][j] = scn.nextInt();
	            }
	        }

	        int dist = minTotalDistance(grid);
	        System.out.println(dist);
	    }

	}


