package StacksAndQueues;

import java.util.*;

public class BalancedBrackets {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		Stack<Character> st = new Stack<>();
		 for(int i = 0; i < str.length(); i++) {
			 char ch  = str.charAt(i);
			 
			 if(ch == '(' || ch == '{' || ch == '[') {
				 st.push(ch)
			 }
		 }
	}

}
