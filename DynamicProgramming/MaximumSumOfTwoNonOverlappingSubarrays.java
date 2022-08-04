package DynamicProgramming;

import java.util.*;

public class MaximumSumOfTwoNonOverlappingSubarrays {
	
	private static int[] nums;

	/**

1. You are given an array(arr) of positive numbers and two numbers X and Y.
2. You have to find the maximum sum of elements in two non-overlapping subarrays.
3. One subarray must of length X and the other must be of length Y.	
	
9
3 8 1 3 2 1 8 9 0
2 3	
	*/
	
	public static int Max_sum(int nums[], int firstLen, int seconLen) {
		
		int len = nums.length;
		
		int dp_prefix[] = new int[len];
		int dp_suffix[] = new int[len];
		
		int sum = 0;
		
		for(int i = 0; i < len; i++) {
			  if(i < firstLen) {
				sum += nums[i];
				dp_prefix[i] = sum;
				
			} else {
				sum += nums[i] - nums[i - firstLen];
				dp_prefix[i] = Math.max(sum, dp_prefix[i - 1]); 
			}
		}
		
		sum = 0;
		
		for(int i = len - 1; i >= 0; i--) {
			if(i + seconLen >= len) {
				sum += nums[i];
				dp_suffix[i] = sum;
				
			} else {
				sum += nums[i] - nums[i + seconLen];
				dp_suffix[i] = Math.max(sum, dp_suffix[i + 1]);
			}
		}
		int ans = 0;
		 for(int i = firstLen - 1; i < len - seconLen; i++) {
			 ans = Math.max(ans, dp_prefix[i] + dp_suffix[i + 1]);
		 }
		
		 return ans;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int ans = Max_sum(arr, x, y);
		 System.out.println(ans);

	}

}
