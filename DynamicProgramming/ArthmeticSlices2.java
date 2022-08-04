package DynamicProgramming;

import java.util.*;

import PRATICE.newname;
/**

1. You are given an array(arr) of integers.
2. You have to find the count of arithmetic slices in the given array.
3. Arithmetic slice is defined as the sub-sequence of an array having all its elements in A.P 
   and length of sub-sequence should be greater than or equal to 3.

4
1
2
3
4

3

*/
public class ArthmeticSlices2 {
	
	public static int Arthmetic(int arr[]) {
		
		int ans = 0;
		
		HashMap<Integer, Integer>[] map = new HashMap[arr.length];
		 for(int i = 0; i < arr.length; i++) {
			 map[i] = new HashMap<>();
		 }
		
		 for(int i = 1; i < map.length; i++) {
			 for(int j = 0; j < i; j++) {
				 
				 long cd = (long)arr[i] - (long)arr[j];
				 
				 /** if it goes over datatype range */
				 if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
					 continue;
				 }
				 
				 int apsendingonj = map[j].getOrDefault((int)cd, 0);
				 int apsendingoni = map[i].getOrDefault((int)cd, 0);
				 
				 ans += apsendingonj; /** we will add only j */
				 map[i].put((int)cd, apsendingoni + apsendingonj + 1);
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
