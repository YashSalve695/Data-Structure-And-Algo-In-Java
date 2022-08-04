
//    Given a balanced parentheses string S, compute the score of the 
//    string based on the following rule:
//    () has score 1
//    AB has score A + B, where A and B are balanced parentheses strings.
//    (A) has score 2 * A, where A is a balanced parentheses string.

//    Score of ()()() string is 3 => 1 + 1 + 1
//    Score of (()) string is 2 => 2 * 1


package StacksAndQueues2;

import java.util.*;
import java.io.*;

public class ScoreOfParaentheses {

	  public static int scoreOfParentheses(String s) {

          Stack<Integer> st = new Stack<>();
        
       // If there is opening bracket in the string
       // then push push -1 in the stack.   
           for(int i = 0; i < s.length(); i++) {
        	   if(s.charAt(i) == '(') {
        		   st.push(-1);
        		   
        	   } else {
      // If closing bracket came in the string then 	
      // on top of the stack is -1,then pop -1
      // And push 1 in the stack.  		   
        		   if(st.peek() == -1) {
        			   st.pop();
        			   st.push(1);
        			   
        		   } else {
        			   
        			   int val = 0;
      // If on top of the stack -1 is not present ,then
      // add that value and pop that   			   
        			   while(st.peek() != -1) {
        				   val += st.pop();
        			   }
        			   st.pop();
      // And pop 1  			   
        			   st.push(2 * val);
      // if there are more than one values
      // then push it in the stack by 2 mul the values
      // present in the stack.  			   
        		   }
        	   }
           }
           int val = 0;
            while(st.size() > 0) {
            	val += st.pop(); 
            }
            return val;
	    }

	    public static void main(String[] args) throws Exception {
	        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

	        int score = scoreOfParentheses(read.readLine());
	        System.out.println(score);
	        
	    }

}
