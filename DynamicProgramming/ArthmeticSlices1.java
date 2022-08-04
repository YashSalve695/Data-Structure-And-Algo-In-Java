package DynamicProgramming;

import java.util.Scanner;

/**

1. You are given an array(arr) of integers.
2. You have to find the count of arithmetic slices in the given array.
3. Arithmetic slice is defined as the sub-array having all its elements in A.P and the 
   length of sub-array should be greater than or equal to 3.


4
1
2
3
4

3

*/
public class ArthmeticSlices1 {

public static int Arthmetic(int arr[]) {
		
		int ans = 0;
		int dp[] = new int[arr.length];
		
		 for(int index = 2; index < arr.length; index++) {
			 if(arr[index] - arr[index - 1] == arr[index - 1] - arr[index - 2]) {
				 dp[index] = dp[index - 1] + 1;
				 ans += dp[index];
			 }
		 }
		return ans;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		 int ans = Arthmetic(arr);
		  System.out.println(ans);
	}
}
