package HashMaps;

import java.util.*;

public class LargestSubarrayEqual012 {
	
	private static int SubarrayEqual012(int arr[]) {
		
		int ans = 0;
		
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int delta10 = count1 - count0;
		int delta21 = count2 - count1;
		
		String key = delta10 + "#" + delta21;
		map.put(key, -1);
		
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
				   int idx = map.get(key);
				   int length = index - idx;
				   
				   if(length > ans) {
					   ans = length;
				   }
			   } else {
				   map.put(key, index);
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
         int length = SubarrayEqual012(arr);
          System.out.println(length);
	}

}
