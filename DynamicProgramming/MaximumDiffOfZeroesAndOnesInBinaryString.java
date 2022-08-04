package DynamicProgramming;

import java.util.*;

/**

1. You are given a string containing only 0's and 1's.
2. You have to find the length of substring which is having maximum difference of 
   number of 0s and number of 1s i.e (Number of 0's - Number of 1's).
3. If there are all 1's present in the given string, then print '-1'.

11000010001
6

*/
public class MaximumDiffOfZeroesAndOnesInBinaryString {
	
	public static int Max_Diff(String str) {
		
		int curr_sum = 0;
		int ans = 0;
		
		for(int i  = 0; i < str.length(); i++) {
			 int val = 0; 
			
			if(str.charAt(i) == '0') {
				val = +1;
				
			} else if(str.charAt(i) == '1') {
				val = -1;
			}
			
			if(curr_sum > 0) {
				curr_sum += val;
				
			} else {
		       curr_sum = val;		
			}
		
		  if(curr_sum > ans) {
			ans = curr_sum;
		  }
		}
		if(ans == 0) { /** This is for if there are all ones */
			return -1;
		}
		return ans;
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int ans = Max_Diff(s);
		 System.out.println(ans);
		
	}

}
