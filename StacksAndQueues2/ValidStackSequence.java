package StacksAndQueues2;

import java.util.*;
import java.io.*;

public class ValidStackSequence {

	 public static boolean validateStackSequences(int[] pushed, int[] popped) {
	        
	        Stack<Integer> st = new Stack<>();
	        
	        int j = 0;
	        // 'j' will iterate on popped array.
	        
	        for(int element : pushed) {
	        	st.push(element);
	       // Intializing for each loop on pushed array
	       // and push that element in stack. 	
	        	
	        	while(st.size() > 0 && st.peek() == popped[j]) {
	       // Do operation till there are elements in stack, and
	       // element present on top of the stack is equal
	       // to element present in popped array. 		
	        		st.pop();
	        		j++;
	       // And increment 'j' on popped array. 		
	        	}
	        }
	        return j == popped.length;
	       // And if 'j' is  at last index of popped array
	       //  Then return.
	    }

	    public static int[] getArr(String s){
	        String nums[] = s.split(" ");
	        int n = nums.length;
	        int ar[] = new int[n];
	        for(int i=0;i<n;i++){
	            ar[i] = Integer.parseInt(nums[i]);
	        }
	        return ar;
	    }
	    
	    public static void main(String[] args) throws Exception {
	        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

	        int pushed [] = getArr(read.readLine());
	        int popped [] = getArr(read.readLine());
	        
	        boolean result = validateStackSequences(pushed, popped);

	        System.out.println(result);
	    }

}
