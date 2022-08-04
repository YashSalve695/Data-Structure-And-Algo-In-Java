package DynamicProgramming;

import java.util.*;

/**

1. You are given an array(arr) of integers.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least one element.

3
1
2
3

6

*/
public class KadanesAlgorithm {
	
	public static int Kadane(int arr[]) {
		
		int current_sum = arr[0];
		int max_sum = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(current_sum >= 0) {
				current_sum += arr[i];
			} else {
				current_sum = arr[i];
			}
			if(current_sum > max_sum) {
				max_sum = current_sum;
			}
		}
		return max_sum;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		int ans = Kadane(arr);
		 System.out.println(ans);

	}

}
