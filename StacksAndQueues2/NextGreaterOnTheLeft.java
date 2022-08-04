package StacksAndQueues2;

import java.io.*;
import java.util.*;

public class NextGreaterOnTheLeft {
	
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

		    int[] ngl = solve(a);
		    display(ngl);
		  }

		  public static int[] solve(int[] arr) {
		    
			  int n = arr.length;
		          // Length of array.
			  
			  int ngl[] = new int[n];
		          // To store the ans.	  
	  		   
			  Stack<Integer> st = new Stack<>();
			      // Declaring stack to get our ans.
			  
			  for(int i = 0; i < n; i++) {
				  // Loop through all the in the arr,till n.
				  
				  while(st.size() > 0 && st.peek() <= arr[i]) {
					  st.pop();
					   // If there are elements in stack.And
					   // element on top of stack is less or
					   // equal to element in arr
					   // then pop that element on stack.
					  
				  }
				  if(st.size() > 0) {
					  ngl[i] = st.peek();
					  // Then ngl is top of the stack.
				  } else {
					  ngl[i] = -1;
					  // or make it -1;
				  }
				  st.push(arr[i]);
				  // And push that current element in stack.
			  }
			  return ngl;
		  }
}
	
