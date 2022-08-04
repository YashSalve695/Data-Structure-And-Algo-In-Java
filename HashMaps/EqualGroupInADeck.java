package HashMaps;

import java.util.*;

public class EqualGroupInADeck {
	
	private static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	private static boolean equalGroup(int deck[]) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		 for(int index = 0; index < deck.length; index++) {
			 int val = deck[index];
			 map.put(val, map.getOrDefault(val, 0) + 1);
		 }
		 int ans = 0;
		 
		  for(int key : map.keySet()) {
			  ans = gcd(ans, map.get(key));
		  }
		  if(ans >= 2) {
			  return true;
			  
		  } else {
			  
			  return false;
		  }
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		boolean res = equalGroup(arr);
		 System.out.println(res);

	}

}
