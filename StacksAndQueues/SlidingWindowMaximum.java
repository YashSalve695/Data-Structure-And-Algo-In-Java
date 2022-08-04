package StacksAndQueues;

import java.util.*;

public class SlidingWindowMaximum {

	public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int arr[] = new int[n];
         for(int i = 0; i < arr.length; i++) {
        	 arr[i] = sc.nextInt();
         }
         int k = sc.nextInt();
         
         Stack<Integer> stack = new Stack<>();
          int nge[] = new int[arr.length];
          
          stack.push(arr.length - 1);
          nge[arr.length - 1] = arr.length;
          
            for(int i = arr.length - 2; i >= 0; i--) {
            	
            	while(stack.size() > 0 && arr[i] > arr[stack.peek()]) {
            		stack.pop();
            	}
            	if(stack.size() == 0) {
            		nge[i] = arr.length;
            	} else {
            		nge[i] = stack.peek();
            	}
            	stack.push(i);
            }
             for(int i = 0; i <= arr.length - k; i++) {
            	 
            	 int j = i;
            	 while(nge[j] < i + k) {
            		 j = nge[j];
            	 }
            	 System.out.println(arr[j]);
             }
          
          
          
          
          
          
          
          
          
          
	}

}
