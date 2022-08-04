package DynamicProgramming;
import java.util.*;

/**

1. coder is wishing to give offerings to all the temples along a mountain range. 
2. The temples are located in a row at different heights.
3. You have to find the minimum number of offerings such that these conditions are fulfilled - 
    -> If two adjacent temples are at different heights, then the temple which is situated at greater height should receive more offerings.
    -> If two adjacent temples are at the same height, then their offerings relative to each other does not matter.

6
1 3 2 5 2 1

10

*/

public class TempleOfferings {
	
	
	public static int totaloffering(int[] height) {
		
	 int left_arr[] = new int[height.length];
	 left_arr[0] = 1;
	 
	   for(int i = 1; i < height.length; i++) {
		   if(height[i] > height[i - 1]) {
			   left_arr[i] = left_arr[i - 1] + 1;
		   } else {
			   left_arr[i] = 1;
		   }
	   }
	 
	   int right_arr[] = new int[height.length];
	   right_arr[height.length - 1] = 1;
	   for(int i = height.length - 2; i >= 0; i--) {
		   if(height[i] > height[i + 1]) {
			   right_arr[i] = right_arr[i + 1] + 1;
		   } else {
			   right_arr[i] = 1;
		   }
	   }
	   int ans = 0;
	    for(int i = 0; i < height.length; i++) {
	    	ans += Math.max(left_arr[i], right_arr[i]);
	    }
	    return ans;
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int height[] = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = scn.nextInt();
		}
		System.out.println(totaloffering(height));
	}

	}


