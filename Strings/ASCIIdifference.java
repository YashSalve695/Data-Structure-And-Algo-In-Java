package Strings;

import java.util.Scanner;

public class ASCIIdifference {
	
	public static String solution(String str) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		
		for(int i = 1; i < str.length(); i++) {
			char current = str.charAt(i);
			char previous = str.charAt(i - 1);

            int gap = current - previous;
            sb.append(gap);
            sb.append(current);
			
		}
		return sb.substring(0);
			}

	
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	       String str = sc.next();
	       System.out.println(solution(str));
	}

}
