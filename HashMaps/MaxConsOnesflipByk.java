package HashMaps;

import java.util.*;

public class MaxConsOnesflipByk {
	
	private static int maxFlip(int arr[], int k) {
		
		int ans = 0;
		
		int j = -1;
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				count++;
			}
			while(count > k) {
				j++;
				if(arr[j] == 0) {
					count--;
				}
			}
			int len = i - j;
			if(len > ans) {
				ans = len;
			}
		  }
		return ans;
		}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = sc.nextInt();
		 }
       int k = sc.nextInt();
       int res = maxFlip(arr, k);
        System.out.println(res);
	}

}
