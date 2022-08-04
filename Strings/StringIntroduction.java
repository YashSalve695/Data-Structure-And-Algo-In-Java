package Strings;

import java.util.Scanner;

public class StringIntroduction {

	public static void main(String[] args) {
		
//		String s1 = "yash";
//		System.out.println(s1);
//		Scanner sc = new Scanner(System.in);
//		
//		String s1 = sc.next();
//		String s2 = sc.nextLine();
//		
//		System.out.println(s1);
//		System.out.println(s2);
//		
		
//		String s = sc.nextLine();
//		System.out.println(s.length());
//		
////		for(int i = 0; i < s1.length(); i++) {
//			char ch = s1.charAt(1);
//			System.out.print(ch);
////		}
	//	System.out.println();
		
		String s = "abc";
         //	System.out.println(s.substring(1, 3));
		 //	System.out.println(s.substring(1)
		
		for(int i = 0; i < s.length(); i++) {
		for(int j = i + 1; j <= s.length(); j++){
			System.out.println(s.substring(i,j));
				
////			
	}
//		
//		String s1 = "yash";
//		String s2 = "Salve";
//		
//		s1 += " ";
//		s1 += "122";
//		s1 += "ew";
		
//		String s3 = s1 + " " + s2;
//		System.out.println(65 + 76 + "hello");
		
		
//		String s = "abc1def1ght1sde";
//		String []parts = s.split("1");
//		for(int i = 0; i < parts.length; i++) {
//			System.out.println(parts[i]);
//		}
//		
		
		StringBuilder sb = new StringBuilder("YASHSALVE");
		System.out.println(sb);
		
		char ch = sb.charAt(0);
		System.out.println(ch);
		/**
		 THIS FUNCTION IS USED TO KNOW WHICH CHARACTER IS PRESENT 
		 ON ANY PARTICULAR INDEX 
		 */
		
		sb.setCharAt(1, 't');
		System.out.println(sb);
		/**
		THIS FUNCTION IS USED TO INSERT NEW WORDS IN THE STRING 
	    ACCORDING WHICH INDEX WE WANT TO INSERT NEW CHARACTER
		*/
	
		sb.insert(2, 'r');
		System.out.println(sb);
		/**
	THIS FUNCTION IS USED TO INSERT A CHARACTER ON A PARTICULAR
	INDEX WITHOUT CHANGING ITS CHARACTER OF ORIGINAL STRING
		*/
		
		sb.deleteCharAt(2);
		System.out.println(sb);
		
		sb.append('g');
		System.out.println(sb);
		/**
	THIS FUNCTION IS USED TO ADD CHARACTER AT END OF ANY STRING
		 */
		
		
		
		
		
		
		
		}
		
	}

}
