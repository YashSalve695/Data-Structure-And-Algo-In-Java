package HashMaps;

import java.util.*;

import PRATICE.newname;

public class GetCommonElement1 {
	
	public static Scanner sc = new Scanner(System.in);
	
	private static void getCommonEle(int arr1[], int arr2[]) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < arr1.length; i++) {
			int val1 = arr1[i];
			map.put(val1, map.getOrDefault(val1, 0) + 1);
		}
		for(int val2 : arr2) {
			if(map.containsKey(val2)) {
				System.out.println(val2);
				map.remove(val2);
			}
		}
		
	}

	public static void main(String[] args) {
		
		int n1 = sc.nextInt();
		int arr1[] = new int[n1];
		 for(int i = 0; i < n1; i++) {
			 arr1[i] = sc.nextInt();
		 }
	    int n2 = sc.nextInt();
		int arr2[] = new int[n1];
		 for(int i = 0; i < n2; i++) {
			 arr2[i] = sc.nextInt();
			 }
		 
		 getCommonEle(arr1, arr2);
	}

}
