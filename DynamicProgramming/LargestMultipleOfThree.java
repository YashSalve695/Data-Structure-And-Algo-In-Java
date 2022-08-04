package DynamicProgramming;

import java.util.*;

public class LargestMultipleOfThree {
	
	
	/**

Given an array of digits digits, return the largest multiple of three that can be formed by 
concatenating some of the given digits in any order. If there is no answer return an empty string.

Since the answer may not fit in an integer data type, return the answer as a string. 
Note that the returning answer must not contain unnecessary leading zeros.


Input: digits = [8,1,9]
Output: "981"

*/
	
	public static String largest_multiple(int digits[]) {
		
		int len = digits.length;
		String ans = "";
		
		int sum = 0;
		Arrays.sort(digits);
		/** sort the arr */
		
		for(int i = 0; i < len; i++) sum += digits[i];
		/** sum of all the elements in the array after sorting */
		
		if(sum % 3 == 0) {
			if(digits[len - 1] == 0) return "0";
			/** we are checking if the array is all of zeros, so return 0*/
			/** we are checking last element because because given array is sorted */
			
			String s = "";
			
            /** we want largest digit, thats why we are adding from last
                because array is sorted */
			for(int i = len - 1; i >= 0; i--) {
				s += "" + digits[i];
			}
			return s;
			
		} else if(sum % 3 == 1) {
			boolean idealfound1 = false;
			
			for(int i = 0; i < len; i++) {
				if(digits[i] % 3 == 1) {
					idealfound1 = true;
					digits[i] = -1;
					 break;
				}
			}
			if(!idealfound1) {
				int index[] = new int[2];
				index[0] = -1;
				index[1] = -1;
				
				for(int i = 0; i < len; i++) {
					if(digits[i] % 3 == 2) {
						if(index[0] == -1) index[0] = i;
						
						else {
							index[1] = i;break;
						}
					}
				}
				
				if(index[1] != -1) {
					digits[index[0]] = -1;
					digits[index[0]] = -1;
				} else return "";
			}
		} else if(sum % 3 == 2) {
			boolean idealfound1 = false;
			
			for(int i = 0; i < len; i++) {
				if(digits[i] % 3 == 2) {
					idealfound1 = true;
					digits[i] = -1;
					 break;
				}
			}
			if(!idealfound1) {
				int index[] = new int[2];
				index[0] = -1;
				index[1] = -1;
				
				for(int i = 0; i < len; i++) {
					if(digits[i] % 3 == 2) {
						if(index[0] == -1) index[0] = i;
						
						else {
							index[1] = i;break;
						}
					}
				}
				
				if(index[1] != -1) {
					digits[index[0]] = -1;
					digits[index[0]] = -1;
				} else return "";
			}
		
			
			for(int i = len - 1; i >= 0; i--) {
				if(digits[i] != -1) ans += ("" + digits[i]);
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
		
		String res = largest_multiple(arr);
		 System.out.println(res);
	}

}
