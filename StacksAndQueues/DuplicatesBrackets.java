package StacksAndQueues;

import java.util.*;

public class DuplicatesBrackets {

	public static void main(String[] args) {
		 
         Scanner sc = new Scanner(System.in);
         String str = sc.next();
         
         Stack<Character> stack = new Stack<>();
          for(int i = 0; i < str.length(); i++) {
        	  char ch = str.charAt(i);
        	  stack.push(ch);
        	  if(ch == ')') {
        		  if(stack.peek() == '(') {
        			  System.out.println(true);
        			  return;
        		  } else {
        			  while(stack.peek() != '(') {
        				  stack.pop();
        			  }
        			  stack.pop();
        		  }
        		  
        	  } else {
        		  stack.push(ch);
        	  }
        		  
          }
         System.out.println(false);
	}
}
