package Strings;

import java.util.Scanner;

public class ToggleClass {
	
	public static String togglecase(String str) {
		
		StringBuilder sb = new StringBuilder(str);
		for(int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			
			if(ch >= 'a' && ch <= 'z') {
				char uppercase = (char)('A' + ch - 'a');
	// It will set all the lowercase letter to upper case.
				sb.setCharAt(i,uppercase);
			}else if(ch >= 'A' && ch <= 'Z') {
				char lowercase = (char)('a' + ch - 'A');
				sb.setCharAt(i,lowercase);
			}
			
		}
		return sb.substring(0);
    // Returns a new String that contains a subsequence 
	// of characters currently contained in this character
	// sequence. The substring begins at the specified index 
	// and extends to the end of this sequence.	
		}		
			
	

	public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       System.out.println(togglecase(str));
	}

}
