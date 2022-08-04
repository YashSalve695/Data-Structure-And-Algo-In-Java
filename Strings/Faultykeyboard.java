package Strings;

import java.util.Scanner;

/**
 * My friend type my name ,and the keyboard is faulty.
 * So,for example he type my name "yash" but because of faulty keyboard
 * the output is getting as : yy aa ss h
 * 
 * We have know which character is pressed multiple times.
 */

public class Faultykeyboard {
	
	public static boolean isPossible(String name,String typed) {
		
		if(name.length() > typed.length()) {
			return false;
		}
		int i = 0;
		int j = 0;
		
		while(i < name.length() && j < typed.length()) {
			
			if(name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			} else if(i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
				j++;
			} else {
				return false;
			}
		}
		while(j < typed.length()) {
			if(name.charAt(i - 1) != typed.charAt(j)) return false;
			j++;
		}
		
		return i < name.length() ? false : true;
	}

	public static void main(String[] args) {
		 
		Scanner sc =  new Scanner(System.in);
		String name = sc.next();
		String typed = sc.next();
		
		boolean result = isPossible(name,typed);
		
		System.out.println(result);

	}

}
