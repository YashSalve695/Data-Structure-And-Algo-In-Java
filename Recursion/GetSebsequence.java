package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSebsequence {
	
	public static ArrayList<String> getSubseq(String str){
		
		if(str.length() == 0) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("");
			return baseresult;
		}
		 
		char ch = str.charAt(0);
		// Remove the first character of string.
		
		String restofstring = str.substring(1);
		// Get substring of rest of the character.
		
		ArrayList<String> result = getSubseq(restofstring);
		// get all the substring.(RECURSIVE CALL)
		
		ArrayList<String> myresult = new ArrayList<>();
		// Store all the result in "myresult".
		
		for(String recursionstr:result) { // For each loop.
			myresult.add("" + recursionstr);
			// Add nothing on each character of substring.
		}
		for(String recursionstr:result) { // For each loop.
			myresult.add(ch + recursionstr);
			// Add first character on every on substring.
		}
		return myresult;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		ArrayList<String> result = getSubseq(str);
		System.out.println(result);
		
	}

}
