package HashMaps;

import java.util.*;

public class CountSubarrayWithEqual1and0 {
	
	private static int CountSubarray0and1(int arr[]) {
		
		int ans = 0;
		int sum = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		
		for(int val : arr) {
			if(val == 0) {
				sum += -1;
				
			} else {
				
				sum += +1;
			}
			if(map.containsKey(sum)) {
				ans += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
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
       int res = CountSubarray0and1(arr);
        System.out.println(res);
	}

}
