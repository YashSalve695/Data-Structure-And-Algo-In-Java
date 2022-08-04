package DynamicProgramming;

import java.util.*;

public class MinCostInMazeTraversal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();

		int arr[][] = new int[n][m];
		 for(int i = 0; i < n; i++) {
			 for(int j = 0; j < m; j++) {
				 arr[i][j] = sc.nextInt();
			 }
		 }
		 
		 int dp[][] = new int[n][m];
		 /** Same as given matrix */
		 
		  for(int row = dp.length - 1; row >= 0; row--) {
			  for(int col = dp[0].length - 1; col >= 0; col--) {
		/** start i and j from destination */		  
				  
				  if(row == dp.length - 1 && col == dp[0].length - 1) {
					  dp[row][col] = arr[row][col];
		/** If i and j is at des index than put the value present
		    in matrix in dp matrix */			  
					  
				  } else if(row == dp.length - 1) {
					  dp[row][col] = dp[row][col + 1] + arr[row][col];
		/** And if i is at last row, add the value present in matrix 
		    in the dp matrix */			  
					  
				  } else if(col == dp[0].length - 1) {
					  dp[row][col] = dp[row + 1][col] + arr[row][col];
		/** And if i is at last col, add the value present in matrix 
		 	in the dp matrix */			  
					 
				  } else {
					  dp[row][col] = Math.min(dp[row + 1][col], dp[row][col + 1]) + arr[row][col];
		/** After that satisfying both the condition , then take out min 
		    from down and right index value and add the value present in the matrix */			  
				  }
			  }
		  }
		  System.out.println(dp[0][0]);
	/** At 0th index in the dp matrix we will get min cost */	  
	}

}


/**
 
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
23

 
 */
