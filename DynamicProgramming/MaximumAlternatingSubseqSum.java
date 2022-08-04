package DynamicProgramming;

import java.util.Scanner;

/**

The alternating sum of a 0-indexed array is defined as the sum of the elements at 
even indices minus the sum of the elements at odd indices.

For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
Given an array nums, return the maximum alternating sum of any subsequence of nums 
 (after reindexing the elements of the subsequence).

A subsequence of an array is a new array generated from the original array by deleting some 
elements (possibly none) without changing the remaining elements' relative order. 
For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), 
while [2,4,2] is not.


Input: nums = [4,2,5,3]
Output: 7
Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum 
(4 + 5) - 2 = 7.

Input: nums = [5,6,7,8]
Output: 8
Explanation: It is optimal to choose the subsequence [8] with alternating sum 8.

*/


public class MaximumAlternatingSubseqSum {
	
	 public static long maxAlternatingSum(int[] nums) {
	        
		 int len = nums.length;
		  
		  long end_even[] = new long[len];
		  long end_odd[] = new long[len];
		  
		  end_even[0] = (long)nums[0];
		  
		   for(int i = 1; i < len; i++) {
			   int curr = nums[i];
			   
			   end_even[i] = Math.max(end_even[i - 1], end_odd[i - 1] + curr);
			   end_odd[i] = Math.max(end_odd[i - 1], end_even[i - 1] - curr);
		   }
		   
		   long ans = Math.max(end_even[len - 1], end_odd[len - 1]);
		 
		   return ans;
	    }
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		long ans = maxAlternatingSum(arr);
         System.out.println(ans);
	}

}
