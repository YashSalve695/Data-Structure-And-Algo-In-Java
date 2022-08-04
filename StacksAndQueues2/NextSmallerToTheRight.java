package StacksAndQueues2;

import java.util.*;
import java.io.*;

public class NextSmallerToTheRight {

	public static void display(int[] a) {
	    StringBuilder sb = new StringBuilder();

	    for (int val : a) {
	      sb.append(val + "\n");
	    }
	    System.out.println(sb);
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(br.readLine());
	    int[] a = new int[n];
	    for (int i = 0; i < n; i++) {
	      a[i] = Integer.parseInt(br.readLine());
	    }

	    int[] nge = solve(a);
	    display(nge);
	  }

	  public static int[] solve(int[] arr) {
	   
		  int n = arr.length;
		  int sr[] = new int[n];
		  
		  Stack<Integer> st = new Stack<>();
		  
		  for(int i = n - 1; i >= 0; i--) {
			  // Loop from last index of array.
			  while(st.size() > 0 && st.peek() >= arr[i])  st.pop();
			  // while there are elements in stack 
			  // And,element in top of the stack
			  // is greater or equal to element present
			  // in the array.
			  // Then remove that element in stack.
				
				  int ans;
				  // Declare our ans,to store.
				  if(st.size() > 0) {
				  // The element which present in our 
				  // stack is our ans.	  
					  ans = st.peek();
				  } else {
					  ans = -1;
				 // or there is no element present
				 // then mark it -1 	  
				  }
				  sr[i] = ans;
				  // Store that ans in our smaller right
				  // array.
				  st.push(arr[i]);
				  // And push that current element in the stack.

			  }
		  
		  return sr;
	  }
	 
}
