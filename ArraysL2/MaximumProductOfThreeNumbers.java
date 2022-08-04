package ArraysL2;

import java.util.*;

public class MaximumProductOfThreeNumbers {
	
	public static int maximumProduct(int arr[]) {
		
		// Currently all the values contain 0 or empty;
		
		int min1 = Integer.MAX_VALUE;
		int min2 = min1;// backup
		// min1 and min2 will hold the negative greater values.
		
		int max1 = Integer.MIN_VALUE;
		int max2 = max1;
		int max3 = max2;
		// max1,max2 and max3 will hold positive greater values.
		
		for(int i = 0; i < arr.length; i++) {
			int val = arr[i];
			
			if(val >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = val;
				
			} else if(val >= max2) {
				max2 = max3;
				max2 = val;
				
			} else if(val >= max3) {
				max3 = val;
			}
			if(val <= min1) {
				min2 = min1;
				min1 = val;
				
			} else if(val <= min2) {
				min2 = val;
			}
		}
		return Math.max(min1 * min2 * max1,max1 * max2 * max3);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		 int res = maximumProduct(arr);
		 System.out.println(res);
	}

}
