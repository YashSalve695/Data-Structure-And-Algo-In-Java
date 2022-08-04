package HashMaps;

import java.util.*;

public class CountOfEquivalentSubarrays {
	
	private static int countSubarrays(int arr[]) {
		
		/** To know the all the distinct integer in the array */
		HashSet<Integer> set = new HashSet<>();
		 for(int i = 0; i < arr.length; i++) {
			 set.add(arr[i]);
		 }
		 int k = set.size();
		 /** size of hashset */
		 
		 int i = -1;
		 int j = -1;
		 int ans = 0;
		 
		 HashMap<Integer, Integer> map = new HashMap<>();
		 
		 while(true) {
			 boolean f1 = false;
			 boolean f2 = false;
			 
			 while(i < arr.length - 1) {
				 f1 = true;
				 i++;
				 
				 map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
				 /** Make frequency map */
				 
				 if(map.size() == k) {
					 ans += arr.length - i;
					 break;
				/** if size of freq map is equal to size of hashset
				    length - where the i is at current index and 
				    add it into ans */
				 }
			 }
			 while(j < i) {
				 f2 = false;
				 j++;
			/** increment j */
				 
				 if(map.get(arr[j]) == 1) {
					 map.remove(arr[j]);
		  /** if element at j index == 1 in map			 
		      then remove that element */
					 
				 } else {
					 
			
			map.put(arr[j], map.getOrDefault(arr[j], 0) - 1);
		/** if that element is not present put that element 	
		    in the map or decrement it by one */
			 }
				 if(map.size() == k) {
					 ans += arr.length - i;
	   /** if size of the map is equal to k, add it in the ans */			
			
				 } else {
					 
					 break;
				 }
			 }
			 if(f1 == false && f2 == false) {
				 break;
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
		int res = countSubarrays(arr);
		 System.out.println(res);
	}

}
