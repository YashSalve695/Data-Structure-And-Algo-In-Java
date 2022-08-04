package StacksAndQueues2;

import java.util.*;
import java.io.*;

  // 1: Given a string S of '(' and ')' parentheses.
  // 2: You need to find count of minimum number of parentheses '(' or ')' when added 
  //    in any positions so that the resulting parentheses string is valid.


public class MinimumAddToMakeParaentheseValid {

	 public static int minAddToMakeValid(String S) {
	       
		 Stack<Character> st = new Stack<>();
		  
		  for(int i = 0; i < S.length(); i++) {
			  char ch = S.charAt(i);
			  // Loop in a String to know
			  // each char present in string.
			  
			  if(ch == '(') {
				  st.push(ch);
			  // If opening bracket is present in the
			  // string than push that char in stack.	  
				  
			  } else {
				  
			  if(st.size() > 0 && st.peek() == '(') {
				  st.pop();
			 // If there are elements present in the stack,
			 // and in top of the stack there is a present
			 // of opening bracket,then pop that char.	  
				  
			  } else {
				  
				  st.push(ch);
			 // If there is closing bracket in the string then 
			 // push that ch in stack.	  
			      }
			  }
		  }
		  return st.size();
	    }

	    public static void main(String[] args) throws Exception {
	    	
	        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

	        int result = minAddToMakeValid(read.readLine());
	        System.out.println(result);
	    }

}
