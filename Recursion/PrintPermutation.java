package Recursion;

import java.util.Scanner;

public class PrintPermutation {
	
	public static void permutation(String ques,String asf) {
		
		if(ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		
		for(int i = 0; i < ques.length();i++) {
			char ch = ques.charAt(i);
			String quesleftpart = ques.substring(0, i);
			String quesrightpart = ques.substring(i + 1);
			
			String roq = quesleftpart + quesrightpart;
			
			permutation(roq,asf + ch);
		}
	}

	public static void main(String[] args) {
		
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       permutation(str,"");
	}

}
