package HashMaps;

import java.util.*;

public class SubarraySumEqualK {
	
	/**
	   TIME  =  O(N)
	   SPACE =  O(N)
	 */
	
	private static int SumEqualk(int arr[], int target) {
		int length = arr.length;
		
		int ans = 0; 
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		
		int sum = 0;
		 for(int i = 0; i < length; i++) {
			 sum += arr[i];
			 
			 if(map.containsKey(sum - target)) {
				 ans += map.get(sum - target);
			 }
			 map.put(sum, map.getOrDefault(sum, 0) + 1);
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
		 int k = sc.nextInt();
		 int sum = SumEqualk(arr, k);
		  System.out.println(sum);
	}

}
