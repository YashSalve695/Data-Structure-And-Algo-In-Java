package DynamicProgramming;

import java.util.*;

public class PrintAllPathWithMinJumps {
	
	public static void Print_all_paths(int arr[]) {
		
		Integer dp[] = new Integer[arr.length + 1];
		
		 for(int i = 0; i < dp.length; i++) {
		    int steps = arr[i];
		    
		    int min = Integer.MAX_VALUE;
		 }
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		 
		 Print_all_paths(arr);
		
	}

}
