package HashMaps;

import java.util.*;

public class LargestSubarrayWithEqual1and0 {
	
	private static int LongestSubarray0and1(int arr[]) {
		
		int ans = 0;
		
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				sum += -1;
				
			} else if(arr[i] == 1) {
				sum += +1;
			}
			if(map.containsKey(sum)){
				int index = map.get(sum);
				int len = i - index;
				if(len > ans) {
					ans = len;
				}
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
       int res = LongestSubarray0and1(arr);
        System.out.println(res);
	}

}
