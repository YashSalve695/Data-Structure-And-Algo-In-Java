package HashMaps;

import java.util.*;

public class LargestSubarrayWith0Sum {
	
	private static int LSZS(int arr[]) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		/** Create map to store the sum and index */
		
		int i = -1;
		/** Currently i will be at -1 index */
		
		int sum = 0;
		/** sum will be 0 intially */
		
		int maxlength = 0;
		/** It will store our ans */
		
		map.put(sum, -1);
		/** put sum and its index in map */
		
		while(i < arr.length - 1) {
		/** do operation till end of the arr */	
			i++;
			sum += arr[i];
		/** And add the element in the arr in the sum */	
			
			if(map.containsKey(sum) == false) {
				map.put(sum, i);
		/** if map does not have sum store in the map		
		    than put that sum and that index in the map*/
				
			} else {
				
		/** if that sum is present in the array than get 
		    the index of that sum and subtract it with
		    current index of that sum */		
				int length = i - map.get(sum);
		/** if curr length is greater than maxlength */		
				if(length > maxlength) {
					maxlength = length;
		/** maxlength will be curr length */			
				}
			}
		}
		return maxlength;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		int res = LSZS(arr);
		 System.out.println(res);
	}

}
