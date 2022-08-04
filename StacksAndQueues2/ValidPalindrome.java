package StacksAndQueues2;

import java.util.Scanner;

public class ValidPalindrome {
	
	public static boolean Validpalindrome(String s) {
		
		int i = 0;
		int j = s.length() - 1;
		
		while(i < j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
				
			} else {
				return palindrome(s,i + 1,j) || palindrome(s,i,j - 1);
		/** IMP CONDITION */		
			}
		}
		return true;
	}
	
	public static boolean palindrome(String s, int i, int j) {
		
		 i = 0;
		 j = s.length() - 1;
		
		while(i < j) {
			
			if(s.charAt(i) == s.charAt(j)) {
				
				i++;
				j--;
				
				return true;
			} else {
		        return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		boolean res = Validpalindrome(str);
		 System.out.println(res);
	
	}

}
