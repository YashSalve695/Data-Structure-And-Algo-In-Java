package DynamicProgramming;

import java.util.*;

public class MaximumSumOfNonAdjacentElements {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = sc.nextInt();
		 }

		 int include = arr[0];
		 int exclude = 0;
		 
		 for(int i = 1; i < arr.length; i++) {
			 int new_include = exclude + arr[i];
			 int new_exclude = Math.max(include, exclude);
			 
			 include = new_include;
			 exclude = new_exclude;
		 }
		 int ans = Math.max(include, exclude);
		 System.out.println(ans);
	}

}


/**
 
6
5
10
10
100
5
6

116

 
 */
