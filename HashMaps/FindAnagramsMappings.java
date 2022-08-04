package HashMaps;

import java.util.*;

public class FindAnagramsMappings {
	
	/** Time Comp - O(n)
	    Space Comp - O(n) */
	
	private static class Pair{
		
		int index = 0;
		ArrayList<Integer> list = new ArrayList<>();
	}
	
	private static int[] AnagramMappings(int arr1[], int arr2[]) {
		
		HashMap<Integer, Pair> map = new HashMap<>();
		
		for(int i = 0; i < arr2.length; i++) {
			if(map.containsKey(arr2[i])) {
				Pair p = map.get(arr2[i]);
				p.list.add(i);
				
			} else {
				
				Pair p = new Pair();
				p.list.add(i);
				map.put(arr2[i], p);
	 /** Add element and its index in the pair */			
			}
		}
		int ans[] = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++) {
			Pair p = map.get(arr1[i]);
			ans[i] = p.list.get(p.index);
			p.index++;
		}
		return ans;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr1[i] = sc.nextInt();
		 }
		int arr2[] = new int[n]; 
		for(int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
     Print(AnagramMappings(arr1, arr2));
	}
	
	private static void Print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
