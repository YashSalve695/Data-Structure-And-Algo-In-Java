package HashMaps;

import java.util.*;

public class ArrayPairDivisibleByK {

	public static void Pair(int arr[], int k) {
		
		HashMap<Integer, Integer> remfreq = new HashMap<>();
		/** To store the remainder freq */
		
		for(int val : arr) {
			int rem = val % k;
	   /** This will gave us remainder */
			
			int oldfreq = remfreq.getOrDefault(rem, 0);
			remfreq.put(rem, oldfreq + 1);
			
		}
		for(int val : arr) {
			int rem = val % 2;
			
			if(rem == 0) {
				int freq = remfreq.get(rem);
				  if(freq % 2 == 1) {/** ODD CONDITION */
					  System.out.println(false);
					  return;
				  }
				
			} else if(2 * rem == k) {
				int freq = remfreq.get(rem);
				  if(freq % 2 == 1) {
					  System.out.println(false);
					  return;
				  }
				
			} else {
				
				int freq = remfreq.get(rem);
				  int oldfreq = remfreq.getOrDefault(k - rem, 0);
				  if(freq != oldfreq) {
					  System.out.println(false);
					  return;
				  }		
			}
		}
		System.out.println(true);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		 int k = sc.nextInt();
		 Pair(arr, k);
	}

}
