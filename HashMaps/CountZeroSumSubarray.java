package HashMaps;

import java.util.*;

public class CountZeroSumSubarray {
	
	public static int ZeroSum(int arr[]) {
		
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int i = -1;
		int sum = 0;
		map.put(0, 1);
		            
		while(i < arr.length - 1) {
			i++;
			
			sum += arr[i];
			
			if(map.containsKey(sum)) {
				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);
				
			} else {
				
				map.put(sum, 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		 int res = ZeroSum(arr);
		  System.out.println(res);
	}

}
