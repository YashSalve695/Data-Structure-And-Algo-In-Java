package HashMaps;

import java.util.*;

public class QuadrupleSumEqualToZeros {
	
	private static int fourSumEqualZero(int arr1[], int arr2[], int arr3[], int arr4[]) {
		
		int count = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int val1 : arr1) {
			for(int val2 : arr2) {
				int sumofala2 = val1 + val2;
				map.put(sumofala2, map.getOrDefault(sumofala2, 0) + 1);
			}
		}
		int target = 0;
		
		  for(int val3 : arr3) {
			  for(int val4 : arr4) {
				  int sumofa3a4 = val3 + val4;
				  count += map.getOrDefault(target - sumofa3a4, 0);
			  }
		  }
		return count;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] arr3 = new int[n];
		int[] arr4 = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr3[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr4[i] = sc.nextInt();
		}
		System.out.println(fourSumEqualZero(arr1, arr2, arr3, arr4));
	}

}

		
	
