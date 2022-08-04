package DynamicProgramming;

import java.util.*;

/**

1. You are given an array(arr) of integers and a number k.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least k elements.

3
1
2
3
2

6

*/
public class MaximumSumSubarrayWithAtLeastSizeK {
	
	private static int Max_Sum_Subarray_k(int arr[], int k) {
		
		int ans = Integer.MIN_VALUE;
		
		int max_sum[] = new int[arr.length];
		/** This will store the maxSum of each element */
		
		int current_sum = arr[0];
		max_sum[0] = current_sum;
		
		for(int i = 1; i < arr.length; i++) {
			 if(current_sum >= 0) {
				 current_sum += arr[i];
			 } else {
				 current_sum = arr[i];
			 }
			 max_sum[i] = current_sum;
		}
		
		int exact_k = 0;
		
		for(int i = 0; i < k; i++) {
			exact_k += arr[i];
		}
		
		 if(exact_k > ans) {
			 ans = exact_k;
		 }
			 
        for(int i = k; i < arr.length; i++) {
        	exact_k += arr[i] - arr[i - k];
        	
        	if(exact_k > ans) {
        		ans = exact_k;
        	}
        	
        	int more_than_k = max_sum[i - k] + exact_k;
        	
        	if(more_than_k > ans) {
        		ans = more_than_k;
        	}
        }
	  return ans;
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < arr.length; i++) {
	      arr[i] = scn.nextInt();
	    }
	    int k = scn.nextInt();
	    System.out.println(Max_Sum_Subarray_k(arr, k));
	  }
	}