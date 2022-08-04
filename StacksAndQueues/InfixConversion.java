package StacksAndQueues;

import java.util.*;

public class InfixConversion {
	
  public static int precendence(char op) {
	  
	  if(op == '+' || op == '-') {
		  return 1;
	  } else if(op == '*' || op == '/') {
		  return 2;
	  } else {
		  return 0;
	  }
  }
  
  public static void process(Stack<Character> ops,Stack<String> post,Stack<String> pre) {
	  char op = ops.pop();
			 
	  String postv2 = post.pop();
	  String postv1 = post.pop();
	  String postvalue = postv1 + postv2 + op;
	     post.push(postvalue);
	     
	  String prev2 = pre.pop();
	  String prev1 = pre.pop();
	  String prevalue = op + prev1 + prev2;
	     pre.push(prevalue);
  }
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String exp = sc.next();
		
		Stack<String> postfix = new Stack<>();
		// These stack will store the postfix expression.
		
		Stack<String> prefix = new Stack<>();
		// These stack will store the prefix expression.
		
		Stack<Character> operators = new Stack<>();
		// And these will store the all operators in the expression.
		
		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			
			if(ch == '(') {
				operators.push(ch);
		// If opening bracket comes,then push that character in the 
		// operators stack.		
				
			} else if((ch >= '0' && ch <= '9') ||
		// These is to check if there is numbers are there in the given exp.
					  (ch >= 'a' && ch <= 'z') ||
		// These to check if there are small alphabets present in the given exp.			  
			          (ch >= 'A' && ch <= 'Z')) {
		// These is to check if there are capital alphabets present in the given exp.		
				
				postfix.push(ch + "");
		// Then push that all the elements in both the stacks
		// by making them to string,by adding double quotes
		// then that element will become our string element.		
				prefix.push(ch + "");
				
			} else if(ch == ')') {
		// If closing bracket came in the given exp,then see
		// in the top of the operators stack that ,is there
	    // opening bracket present in the stack or traverse 
	    // in the till it dont find opening bracket.			
				while(operators.peek() != '(') {
					
					process(operators,postfix,prefix);
		// If it finds the opening bracket,then process the
		// operation between that elements which are present
	    // inside opening and closing brackets.				
				}
				operators.pop();
	    // And pop out the closing bracket also.			
				
			} else if(ch == '+' || ch == '-' ||
					  ch == '*' || ch == '/') {
		// If above operators came in the stack,then do the 
		// following operation.		
				
				while(operators.size() > 0 && operators.peek() != '(' &&
					  precendence(ch) <= precendence(operators.peek())) {
		// According to the priority we have to calculate 			
					process(operators,postfix,prefix);
		// These will process the calculation according to 
		// which operator have high priority.			
				}
				operators.push(ch);
			}
		}
		        while(operators.size() > 0) {
		        	char op = operators.peek();
		        	
		        	process(operators,postfix,prefix);
		        			
		        }
		       
		        System.out.println(postfix.pop());
		        System.out.println(prefix.pop());
	}
	 
}



