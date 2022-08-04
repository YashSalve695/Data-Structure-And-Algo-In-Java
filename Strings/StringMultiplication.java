package Strings;

import java.util.*;

public class StringMultiplication {

	public static String MultiplyString(String num1, String num2) {
		
		if(num1.equals("0") || num2.equals("0")) return "0";
		
		int l1 = num1.length();
		// Length of string one;
		
		int l2 = num2.length();
		// Length of string two.
		
		int res[] = new int[l1 + l2];
		// Result will be between length of two string.
		
		int i = l2 - 1;
		// i will be at last index of string num2.
		
		int pf = 0; // For 'x' condition
		// It will satisfy this condition ---> 12* 
		//                                    12**
		
		while(i >= 0) {
	   // i will do operation till there are elemets in the string.		
			
			int ival = num2.charAt(i) - '0';
			i--;
			
			int j = l1 - 1;
			int k = res.length - 1 - pf;
			int carry = 0;
			
			while(j >= 0 || carry != 0) {
				
				int jval = j >= 0 ? num2.charAt(j) - '0' : 0;
				j--;
				
				int product = ival * jval + carry + res[k];
				
				res[k] = product % 10;
				carry = product / 10;
				k--;
			}
			pf++;
		}
		String str = "";
		boolean flag = false;
		 for(int val : res) {
			 if(val == 0 && flag == false) {
				 
			 } else {
				 flag = true;
				 str += val;
			 }
		 }
		 return str;
	}

	public static void main(String[] args) {
		
       Scanner sc = new Scanner(System.in);
       String str1 = sc.next();
       String str2 = sc.next();
       
       String res = MultiplyString(str1,str2);
        System.out.println(res);
		
	}

}
