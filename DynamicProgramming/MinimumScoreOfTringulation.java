package DynamicProgramming;

import java.util.*;

public class MinimumScoreOfTringulation {
	
	/**
	 
1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
2. You have to triangulate the given polygon into N-2 triangles.
3. The value of a triangle is the product of the labels of vertices of that triangle.
4. The total score of the triangulation is the sum of the value of all the triangles.
5. You have to find the minimum score of the triangulation of the given polygon.

3
1 2 3

6

	 */
	
	
	public static int minScoreTriangulation(int[] arr) {
		
		int dp[][] = new int[arr.length][arr.length];
		
		 for(int gap = 0; gap < dp.length; gap++) {
			 
			 for(int i = 0, j = gap; j < dp[0].length; i++, j++) {
				 
				 if(gap == 0) {
					 dp[i][j] = 0;/** if there is no point */
					 
				 } else if(gap == 1) { /** if there is only one point than, there is also no tri */
					 dp[i][j] = 0;
					 
				 } else if(gap == 2) {
					 dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
					 
				 } else {
					 int min = Integer.MAX_VALUE;
					 for(int k = i + 1; k <= j - 1; k++) {
						 
						 int triangle = arr[i] * arr[j] * arr[k];
						 int left = dp[i][k];
						 int right = dp[k][j];
						 
						 int total = triangle + left + right;
						 if(total < min) {
							 min = total;
						 }
					 }
					 dp[i][j] = min;
				 }
				 
			 }
		 }
		return dp[0][dp[0].length - 1];
    }
	

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
		for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr));

	}

}
