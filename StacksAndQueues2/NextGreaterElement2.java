package StacksAndQueues2;

import java.util.*;
import java.io.*;

public class NextGreaterElement2 {

	  public static int[] nextGreaterElementII(int[] nums) {
	       
		  int n = nums.length;
		  // Length of the array.
		  
		  Stack<Integer> st = new Stack<>();
		  // Declare the stack 
		  
		  for(int i = n - 2; i >= 0; i--) {
		  // Loop form to see from second last index
			  
			  while(st.size() > 0 && st.peek() <= nums[i]) {
				  st.pop();
		  // If there are elements in stack,And top
		  // of the element present in the stack
		  // should be less or equal the elements
		  // present in the array.		  
			  }
			  st.push(nums[i]);
		// After that,push the current element in the array
		// in the stack.	  
		  }
		  int ans[] = new int[n];
	    // To store the ans.Which we will return at
		// the end.  
		  
		   for(int i = n - 1; i >= 0; i--) {
		// Loop will run from last index of array.	   
			   while(st.size() > 0 && st.peek() <= nums[i]) {
				   st.pop();
	    // If there are elements in stack,And top
	    // of the element present in the stack
	    // should be less or equal the elements
	    // present in the array.		   
			   }
			   ans[i] = st.size() == 0 ? -1 : st.peek();
	    // If stack sizde is zero then return -1,
		// or make top of the element of stack our answer. 	   
			     st.push(nums[i]);
		// And push that element in the array to stack.	     
		   }
		   return ans;
		// At last return our ans.   
	    }


	    public static void main(String[] args) throws Exception {
	        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

	        int n = Integer.parseInt(read.readLine());
	        int nums[] = new int[n];
	        for(int i=0;i<n;i++){
	            nums[i] = Integer.parseInt(read.readLine());
	        }
	        
	        int ans[] = nextGreaterElementII(nums);

	        n = ans.length;

	        System.out.println(n);
	        for(int e: ans){
	            System.out.println(e);
	        }
	        
	    }
}
