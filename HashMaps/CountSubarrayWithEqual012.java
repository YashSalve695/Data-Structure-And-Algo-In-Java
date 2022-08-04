package HashMaps;

import java.util.*;

public class CountSubarrayWithEqual012 {
	
	private static int CountSubarray012(int arr[]) {
		
         int ans = 0;
		
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int delta10 = count1 - count0;
		int delta21 = count2 - count1;
		
		String key = delta10 + "#" + delta21;
		map.put(key, 0);
		
		for(int index = 0; index < arr.length; index++) {
			   int val = arr[index];
			   if(val == 0) {
				   count0++;
				   
			   } else if(val == 1) {
				   count1++;
				   
			   } else {
				   count2++;
			   }
			   
			   delta10 = count1 - count0;
			   delta21 = count2 - count1;
			   
			   key = delta10 + "#" + delta21;
			   
			   if(map.containsKey(key)) {
				   ans += map.get(key);
				   map.put(key, map.get(key) + 1);
				   
			   } else {
				   
				   map.put(key, 1);
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
       int count = CountSubarray012(arr);
        System.out.println(count);
	}

}
