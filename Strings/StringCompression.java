package Strings;

import java.util.Scanner;

public class StringCompression {
	
	public static String Compression1(String str) {
		
		/**
		 TO GET THE FIRST CHARACTER OF STRING
		 */
		String s = str.substring(0,1);
		/**
		 LOOP WILL START FROM "1" CHARACTER
		 */
		for(int i = 1; i < str.length(); i++) {
			 
		 char current = str.charAt(i);//FIRST CHARACTER OF STRING	
		 char previous = str.charAt(i - 1);//ZERO CHARACTER OF STRING
			 
			 if(current != previous) {
				 s += current;
			 }
		 }
		 return s;
	}
	public static String Compression2(String str) {
		
		String s = str.substring(0,1);
		int count = 1;
		
		for(int i = 1; i < str.length(); i++) {
			
			char current = str.charAt(i);
			char previous = str.charAt(i - 1);
			
			if(current == previous) {
				count++;
			}else {
				if(count > 1) {
					s += count;
					count = 1;
				}
					s += current;
			}
		}
		if(count > 1) {
			s += count;
			count = 1;
		}
		return s;
	}
	

	public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
         String s = sc.next();
         System.out.println(Compression1(s));
         System.out.println(Compression2(s));
         

	}

}
