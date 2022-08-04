package Recursion;

import java.util.Scanner;

public class AllPalindromicPartition {
	
	public static void PP(String str,String asf) {
		
		if(str.length() == 0) {
			System.out.println(asf);
			return;
		}
		for(int i = 0; i < str.length(); i++) {
			String prefix = str.substring(0,i + 1);
			String ros = str.substring(i + 1);
			 if(isPalindrome(prefix)) {
				 PP(ros,asf + "(" + prefix + ")");
			 }
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		PP(str,"");
		
	}
	public static boolean isPalindrome(String str) {
		
		int left = 0;
		int right = str.length() - 1;
		
		while(left < right) {
			
			char le = str.charAt(left);
			char ri = str.charAt(right);
			if(left != right) {
				return false;
			}
			left++;
			right--;
			
		}
		return true;
	}

}
