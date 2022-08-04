package Strings;

import java.util.Scanner;

public class PalindromicSubstring {
	
	// FUNCTION TO SHOW FROM WHERE "i" AND "j" WILL BE START 
	public static void solution(String s) {
		
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j <= s.length(); j++) {
				
				String ss = s.substring(i, j);
				if(isPalindrome(ss) == true) {
					count++;
					System.out.println(ss);
				}
				System.out.println(count);
			}
		}
	}
	
	//FUNCTION TO CHECK IF FIRST AND LAST INDEX ARE EQUAL OR NOT//
	public static boolean isPalindrome(String s) {
		
		int i = 0;
		int j = s.length() - 1;
		
		while(i <= j) {
		char ch1 = s.charAt(i);
		char ch2 = s.charAt(j);
		
		if(ch1 != ch2) {
			return false;
		}else {
			i++;
			j--;
		}
		
		}
		return true;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();//INPUT OF STRING //
		solution(str);
		System.out.println(isPalindrome(str));
	}

}
