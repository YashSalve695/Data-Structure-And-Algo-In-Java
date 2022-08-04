package DynamicProgramming;

import java.util.*;

/**

1. You are given a number N, which represents the count of buttons pressed on a mobile numeric 
   keypad.
2. You can only press buttons that are up, left, right, down to the current button and the 
   current button also.
3. You can not press bottom row corner buttons(* and #).

4. You have to find the count of different numbers that can be generated by pressing N number 
   of buttons.

2
36

*/
public class LetterCombOfPhoneNo {
	
	static int data[][] = {
			
	    	{0, 8}, // -> 0
			{1, 2, 4}, // -> 1
			{1, 2, 3, 5}, // -> 2
			{2, 3, 6}, // -> 3
			{1, 4, 5, 7}, // -> 4
			{2, 4, 5, 6, 8}, // -> 5
			{3, 5, 6, 9}, // -> 6
			{4, 7, 8}, // -> 7
			{5, 7, 8, 9, 0}, // -> 8
			{6, 8, 9}, // -> 9
			
	};
	
	public static int Letter_Comb(int pressed) {
		                    
		int dp[][] = new int[pressed + 1][10];
		
		for(int row = 1; row <= pressed; row++) {
			for(int col = 0; col <= 9; col++) {
				
				if(row == 1) {
					dp[row][col] = 1;
					
				} else {
					for(int prev : data[col]) {
						dp[row][col] += dp[row - 1][prev];
					}
				}
			}
		}
		int sum = 0;
		 for(int s = 0; s <= 9; s++) {
			 sum += dp[pressed][s];
		 }
		return sum;
	}

	public static void main(String[] args) {
		
	 Scanner sc = new Scanner(System.in);
	 
	 int n = sc.nextInt();
	 int ans = Letter_Comb(n);
	  System.out.println(ans);

	}

}