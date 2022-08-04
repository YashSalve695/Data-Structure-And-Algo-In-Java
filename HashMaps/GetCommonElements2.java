package HashMaps;

import java.util.*;

public class GetCommonElements2 {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n1 = sc.nextInt();
		int arr1[] = new int[n1];
		 for(int i = 0; i < n1; i++) {
			 arr1[i] = sc.nextInt();
		 }
		int n2 = sc.nextInt();
		int arr2[] = new int[n2];
		for(int i = 0; i < n2; i++) {
			arr2[i] = sc.nextInt();
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int val : arr1) {
			if(map.containsKey(val)) {
				int oldfreq = map.get(val);
				int newfreq = oldfreq + 1;
				map.put(val, newfreq);
						
			} else {
				map.put(val, 1);
			}
		}
		for(int val : arr2) {
			if(map.containsKey(val) && map.get(val) > 1) {
				System.out.println(val);
				int oldfreq = map.get(val);
				int newfreq = oldfreq - 1;
				map.put(val, newfreq);
			}
		}
	}

}
