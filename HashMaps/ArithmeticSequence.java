package HashMaps;

import java.util.*;

public class ArithmeticSequence {
	
	private static boolean AP(int arr[]) {
		
		if(arr.length <= 1) {
			return true;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		HashSet<Integer> set = new HashSet<>();
		
		 for(int val : arr) {
			 min = Math.min(val, min);
			 max = Math.max(val, max);
			 set.add(val);
		 }
		 int difference = (max - min) / (arr.length - 1);
		  for(int i = 0; i < arr.length; i++) {
			  int Ap = min + i * difference;
			  
			  if(set.contains(Ap) == false) {
				  return false;
			  }
		  }
		  return true;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		boolean res = AP(arr);
		 System.out.println(res);
	}

}
