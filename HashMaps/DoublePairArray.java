package HashMaps;

import java.util.*;

public class DoublePairArray {
	
	private static boolean DoublePair(int arr[]) {
		
		if(arr.length == 0) return true;
		
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		       for(int element : arr) {
			   freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
		 }
		 
		 /** For negative values */
		  Integer[] ar = new Integer[arr.length];
		   for(int i = 0; i < arr.length; i++) {
			   ar[i] = arr[i];
		   }   
			   Arrays.sort(ar, (a,b) -> { // Sort the array, this is beacuse of negative elements
				 return Math.abs(a) - Math.abs(b);  
			   });
			   
			   for(int element : ar) {
				   if(freqMap.get(element) == 0) continue;
				   
				   if(freqMap.getOrDefault(2 * element, 0) == 0) return false;
				   
				   freqMap.put(element, freqMap.get(element) - 1);
				   freqMap.put(2 * element, freqMap.get(2 * element) - 1);
			   
		   }
		   return true;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = sc.nextInt();
		 }
		boolean res = DoublePair(arr);
		 System.out.println(res);

	}

}
