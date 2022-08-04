package Recursion;

import java.util.*;

public class InvalidParentheses {
	
	public static void Invalidparentheses(String str,int mra,HashSet
			                         <String> ans) {
			
		if(mra == 0) {
			int minre = getmin(str);
			 if(minre == 0) {
				 if(!ans.contains(str)) {
					 System.out.println(str);
					 ans.add(str);
				 }
			 }
			 return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			String left = str.substring(0,i);
			String right = str.substring(i + 1);
			Invalidparentheses(left + right,mra - 1,ans);
		}
	}
	
	public static int getmin(String str) {
		
		Stack<Character> st = new Stack<>();
		
		  for(int i = 0; i < str.length(); i++) {
			  char ch = str.charAt(i);
			  
			  if(ch == '(') {
				  st.push(ch);
			  } else if(ch == ')') {
				  if(st.size() == 0) {
				  st.push(ch);
			  } else if(st.peek() == ')') {
				  st.push(ch);
			  } else if(st.peek() == '(') {
				  st.pop();
			    }
			  }	
		  }
		  return st.size();
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		Invalidparentheses(str,getmin(str),new HashSet<>());
	}

}
