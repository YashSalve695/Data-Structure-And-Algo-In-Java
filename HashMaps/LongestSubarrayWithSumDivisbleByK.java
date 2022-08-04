package HashMaps;

import java.util.*;

public class LongestSubarrayWithSumDivisbleByK {
	
	private static int SubarrayDivisblebyK(int arr[], int k) {
		
		int ans = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int rem = 0;
		map.put(0, -1); // key - sum / value - index;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			rem = sum % k;
			
			if(rem < 0) {
				rem += k;
			}
			if(map.containsKey(rem)) {
				int index = map.get(rem);
				int length = i - index;
				
				if(length > ans) {
					ans = length;
				}
			} else {
				
				map.put(rem, i);
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
		 int k = sc.nextInt();
	  int res = SubarrayDivisblebyK(arr, k);
	   System.out.println(res);
	}

}
