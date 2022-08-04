package HashMaps;

import java.util.*;

public class LargestSubarrayWithContElements {
	
	public static int LSWCE(int arr[]) {
		
		int ans = 0;
		
		for(int i = 0; i < arr.length - 1; i++) {
		/** i will be at first element in the array */
			
			int min = arr[i];
		/** currently min will be our first element */
			
			int max = arr[i];
	   /** And max will be our first element */		
			
			HashSet<Integer> dup = new HashSet<>();
	   /** Make hashset for to check for duplicasy */
			dup.add(arr[i]);
	   /** add every element in the hashset */		
			
			for(int j = i + 1; j < arr.length; j++) {
				if(dup.contains(arr[j])) {
					break;
	   /** j will start from 2 index if the element is 				
	        already present in the hashset then break */
				}
				dup.add(arr[j]);
	   /** if that element is not present in the hashset
	        then add that element in the hashset */ 			
	    
				min = Math.min(min, arr[j]);
	  /** Take out min from curr min and element present			
	       in the arr */
				max = Math.max(max, arr[j]);
	  /** Take out max from curr max and element present			
		   in the arr */			
				
				if(max - min == j - i) {
	  /** curr max and curr min is equal to index of 				
	       i and j  */
					int length = j - i + 1;
	  /** To take out length subtract index of j and i and add 1 */				
					if(length > ans) {
	  /** if current ans is greater than length ,than ans					
	      will be our length */
						ans = length;
					}
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
	   int res = LSWCE(arr);
	    System.out.println(res);
	}

}
