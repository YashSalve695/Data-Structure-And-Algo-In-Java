package ArraysL2;

import java.util.*;

public class NumberOfSubarraysWithBoundedMaximum {
	
	public static int Max_Subarray(int arr[], int left, int right)
	{
		
		int si = 0;
		int ei = 0;
		
		int len = arr.length;
		int ans = 0;
		int prev_count = 0;
		
		while(ei < len) {
			if(left <= arr[ei] && arr[ei] <= right) {// case 1
				
				prev_count = ei - si + 1;
				ans += prev_count;
				
			} else if(arr[ei] < left) {// case 2
				ans += prev_count;
			} else {// case 3
				si = ei + 1;
				prev_count = 0;
          /** here prevcount will become 0 becuse */
			}
			ei++;
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
		int left = sc.nextInt();
		int right = sc.nextInt();
		
       int res = Max_Subarray(arr, left, right);
        System.out.println(res);
	}

}
