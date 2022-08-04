package Recursion;

import java.util.Scanner;

public class PrintSebsequence {
	
	public static void subsequence(String ques,String ans) {
		
		if(ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		
		subsequence(roq,ans + ch);
		subsequence(roq,ans + "");
	}

	public static void main(String[] args) {
		
     Scanner sc = new Scanner(System.in);
     String str = sc.next();
     
     subsequence(str,"");
	}

}
