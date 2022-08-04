package StacksAndQueues;

import java.util.*;

public class InfixEvaluation {
	
	
	  public static int precedence(char operator) {
		
		if(operator == '+') {
			return 1;
		} else if(operator == '-') {
			return 1;
		} else if(operator == '*') {
			return 2;
		} else {
			return 2;
		}
	}
	  public static int operation(int v1,int v2,char operator) {
		  
		  if(operator == '+') {
			  return v1 + v2;
		  } else if(operator == '-') {
			  return v1 - v2;
		  } else if(operator == '*') {
			  return v1 * v2;
		  } else {
			  return v1 / v2;
		  }
	  }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine();
		
		// Make two stack to store the operators
		// And Operands
		
		Stack<Integer> operands = new Stack<>();
		// Operands will store all the numbers.
		
		Stack<Character> operators = new Stack<>();
		// Operators wil store all the characters.
		
		 for(int i = 0; i < exp.length(); i++) {
			 char ch = exp.charAt(i);
		// Loop in the exp to fill the both the stacks
	    // acccording to their giving data.
			 
			 if(ch == '(') {
				 operators.push(ch);
		// If there is a opening brackets then push the
	    // elements in the operators
				 
			 } else if(Character.isDigit(ch)) {
				 operands.push(ch - '0');
		// These will gives us the integer which is present
		// in the string and Character.And push that integer 
		// in the operands stacks.
				 
			 }else if(ch == ')') {
		// If closing bracket will come.
				 
				 while(operators.peek() != '(') {
		// It will remove all the operators till it dont
		// find opening bracket.			 
					 char operate = operators.pop();
		
		// v1 and v2 are the operands or digit in the '(' 
		// and ')'brackets.			 
					 int v2 = operands.pop();
		// Here top element will pop first so that
		// will be our incrementing element.			 
					 int v1 = operands.pop();
		// And after that element will pop whichever
		// next element will pop will be our v1.			 
					 
			int opv = operation(v1,v2,operate);
			  operands.push(opv);
		// This will perform all the calculation
	    // And store it in the operand stack		  
				 }
				 operators.pop();
				 
			 } else if(ch == '+' || ch == '-' || ch == '*'
					  || ch == '/') {
				 
				 while(operators.size() > 0 && operators.peek()
					   != '(' && precedence(ch) <= precedence(operators.peek())) {
					 
					 char operate = operators.pop();
					 int v2 = operands.pop();
					 int v1 = operands.pop();
					 
			int opv = operation(v1,v2,operate);
			 operands.push(opv);
				 }
				 operators.push(ch);
			 }
		 }
		while(operators.size() != 0) {
			
			char operate = operators.pop();
			 int v2 = operands.pop();
			 int v1 = operands.pop();
			 
		int opv = operation(v1,v2,operate);
		 operands.push(opv);
		}
		System.out.println(operands.peek());
	}

}
