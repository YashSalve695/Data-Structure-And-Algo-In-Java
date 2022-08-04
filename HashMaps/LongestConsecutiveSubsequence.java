package HashMaps;

import java.util.*;

public class LongestConsecutiveSubsequence {
	
	public static int LCS(int arr[]) {
		
		int res = 0;
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(int val : arr) {
			map.put(val, true);
		}
		for(int val : arr) {
			if(map.containsKey(val - 1)) {
				map.put(val,false);
			}
		}
		int maxstartpoint = 0;
		int maxlength = 0; 
		
		for(int val : arr) {
			if(map.get(val) == true) {
				int templength = 1;
				int tempstartpoint = val;
				
				while(map.containsKey(tempstartpoint + templength)) {
					templength++;
				}
				if(templength > maxlength) {
					maxstartpoint = tempstartpoint;
					maxlength = templength;
				}
			}
		}
		for(int i = 0; i < maxlength; i++) 
			return maxstartpoint + i;
	}

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
       int res = LCS(arr);
        System.out.println(res);
	}

}
