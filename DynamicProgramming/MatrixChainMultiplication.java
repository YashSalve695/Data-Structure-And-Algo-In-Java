package DynamicProgramming;

import java.util.*;

import javax.swing.SpinnerDateModel;

public class MatrixChainMultiplication {
	
	
	/**

1. You are given an array(arr) of positive integers of length N which represents the dimensions 
    of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of 
   matrices.
   
3
1
2
3

6

*/
	public static int mcm(int[] arr){
		
		int dp[][] = new int[arr.length - 1][arr.length - 1];
		
		for(int gap = 0; gap < dp.length; gap++) {
              for(int row = 0, col = gap; col < dp.length; row++, col++) {
				
				if(gap == 0) {
					dp[row][col] = 0;
					
				} else if(gap == 1) {
					dp[row][col] = arr[row] * arr[col] * arr[col + 1];
					
				} else {
					int min = Integer.MAX_VALUE;
					
					for(int split = row; split < col; split++) {
						
						int left_half = dp[row][split];
						int right_half = dp[split + 1][col];
						int multi_cost = arr[row] * arr[split + 1] * arr[col + 1];
						
						int total_cost = left_half + right_half + multi_cost;
						
						if(total_cost < min) {
							min = total_cost;
						}
					}
					dp[row][col] = min;
				}
			}
		}
		return dp[0][dp.length - 1];
	}
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcm(arr));
	}



}
