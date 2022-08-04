package Strings;

import java.util.*;

public class AddString {
	
	public static String addString(String s1,String s2) {
		
		String res = "";
		// To store the ans.
		
		int i = s1.length() - 1;
		// i will be at last index of string s1.
		
		int j = s2.length() - 1;
		// j will be at last index of string s2.
		
		int carry = 0;
		// carry will be currently 0.
		
		while(i >= 0 || j >= 0 || carry != 0) {
		// Operation will run till there are elements
		// string s1 and s2 and carry .	
			
		int ival = i >= 0 ? s1.charAt(i) - '0' : 0;
		// It will give element in s1,If element is not present
		// it will return 0.
		
		int jval = j >= 0 ? s2.charAt(j) - '0' : 0;
		// It will give element in s2,If element is not present
		// it will return 0.
			
			i--;
			j--;
		// i and j will decrease.
			
			int sum = ival + jval + carry;
		// It will add all the values of element present
		// in s1 and s2 and carry.
			
			res = (sum % 10) + res;
		// It will give us the res,by sum mod 10.
			
			carry = sum / 10;
		// And sum divide by 10, will gave us carry.	
		}
		return res;
		// return ans.
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
		String res = addString(s1,s2);
		System.out.println(res);

	}

}
