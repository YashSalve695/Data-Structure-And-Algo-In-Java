package StacksAndQueues2;

import java.util.*;

public class TrappingRainWater2 {

	/** 12
	    0 1 2 1 0 1 3 2 1 2 1 */
	
	/** TIME -- O(N)
	    SPACE -- O(1)
	 */
	
	public static int trap(int height[]) {
		
		int left = 0;
		// Left is currently at starting index.
		
		int right = height.length - 1;
		// right is currently at last index .
		
		int lmax = 0;
		// Value of leftmax is 0, currently.
		
		int rmax = 0;
		// Value of rightmax is 0, currently.
		
		int ans = 0;
		// At the end return ans.
		
		while(left < right) {
		// Loop run till left is less than right.
			
			lmax = Math.max(lmax, height[left]);
		// Take out maximum from leftmax and element 
		// present in the array.
			
			rmax = Math.max(rmax, height[right]);
		// Take out maximum from leftmax and element 
		// present in the array.	
			
			if(lmax < rmax) {
		// If value of lmax is less than rmax
		// Then add the value of lmax by subtracting it with
		// element in array of left in ans.
		// And increment left.		
				ans += lmax - height[left];
				left++;
				
			} else {
				
				ans += rmax - height[right];
				right--;
		// If value of rmax is greater than lmax
		// Then add the value of rmax by subtracting it with
		// element in array of right in ans.
		// And increment right.			
			}
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
		int res = trap(arr);
		 System.out.println(res);
	}

}
