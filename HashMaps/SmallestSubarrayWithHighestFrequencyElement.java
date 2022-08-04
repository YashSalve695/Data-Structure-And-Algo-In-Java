package HashMaps;

import java.util.*;

public class SmallestSubarrayWithHighestFrequencyElement {
	
	private static void SmallestSubarrayHighFreq(int arr[]) {
		
		/** This map will store the frequency of each element in array */
		HashMap<Integer, Integer> fmap = new HashMap<>();
		
		/** This map will store the element and its index of occurence */
		HashMap<Integer, Integer> startPoint = new HashMap<>();
		
		int highfreq = 0;
		int startIndex = 0;
		int endIndex = 0;
		int length = endIndex - startIndex + 1;
		
		for(int index = 0; index < arr.length; index++) {
			int val = arr[index];
			if(fmap.containsKey(val)) {
				fmap.put(val, fmap.getOrDefault(val, 0) + 1);
				
			} else {
				
				fmap.put(val, 1);
				startPoint.put(val, index);
			}
			if(fmap.get(val) > highfreq) {
				highfreq = fmap.get(val);
				startIndex = startPoint.get(val);
				endIndex = index;
				length = endIndex - startIndex + 1;
				
			} else if(fmap.get(val) == highfreq) {
				int clen = index - startPoint.get(val);
				if(clen < length) {
					highfreq = fmap.get(val);
					startIndex = startPoint.get(val);
					endIndex = index;
					length = endIndex - startIndex + 1;
				}
			}
		}
		System.out.println(arr[startIndex]);
		System.out.println(startIndex);
		System.out.println(endIndex);
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		SmallestSubarrayHighFreq(arr);

	}

}
