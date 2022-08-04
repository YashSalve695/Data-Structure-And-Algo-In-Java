
    /** Given string num representing a non-negative integer num, and an integer k, 
        print the smallest possible integer after removing k digits from num. **/

package StacksAndQueues2;

import java.util.*;

public class RemoveKDigits {

	public static void main(String[] args) {
		
		// Input 
		Scanner sc = new Scanner(System.in);
		String nums = sc.next();
		int k = sc.nextInt();
		
		Stack<Character> st = new Stack<>();
		
		// Loop in the string ,to know each character
		 for(int i = 0; i < nums.length(); i++) {
			 char ch = nums.charAt(i);
			 
		// Do operation still there are elements in stack,
		// And given k is is not equal to 0,And
	    // Element on top of the stack is greater than current char
		// then pop that element and decrement k.	 
			 while(st.size() > 0 && k > 0 && st.peek() > ch) {
			    st.pop();
			    k--;
			 }
		// And push that current character.	 
			 st.push(ch);
		 }
		// If k is greater than 0,then pop that element 
		// in stack and decrement k. 
		 while(k > 0) {
			 st.pop();
			 k--;
		 }
		// To store the ans,make char array
		// we will fill the array from end. 
		 char ans[] = new char[st.size()];
		 int fill = ans.length - 1;
		 while(fill >= 0) ans[fill--] = st.pop();
		 
		 // This codition is for leading zeroes
		 int d = 0;
		 while(d < ans.length && ans[d] == '0') d++;
		 
		 StringBuilder sb = new StringBuilder();
		 
		 while(d < ans.length) sb.append(ans[d++]);
		  if(sb.length() == 0) sb.append('0');
		  
		  System.out.println(sb);
		  // print ans
	}

}
