package StacksAndQueues2;

import java.util.*;
import java.io.*;

public class NextGreaterElement1 {
	
	public static int[] ngr(int[] arr){
	    
		 int ans[] = new int[arr.length];
		 
		 Stack<Integer> st = new Stack<>();
		 st.push(arr[arr.length - 1]);
		 
		 ans[arr.length - 1] = -1;
		   for(int i = arr.length - 2; i >= 0; i--) {
			   
			   while(st.size() > 0 && arr[i] >= st.peek()) {
				   st.pop();
			   }
			   if(st.size() == 0) {
				   ans[i] = -1;
			   } else {
				   ans[i] = st.peek();
			   }
			   st.push(arr[i]);
		   }
	 return ans;
	 }

	 public static int[] nextGreaterElement(int[] nums, int[] query) {
		 
	        Stack<Integer> st = new Stack<>();
	         int nextGreater[] = ngr(nums);
	        
	         HashMap<Integer,Integer> map = new HashMap<>();
	            for(int i = 0; i < nums.length; i++) {
	            	map.put(nums[i], nextGreater[i]);
	            }
	            int ans[] = new int[query.length];
	              for(int i = 0; i < query.length; i++) {
	            	  ans[i] = map.get(query[i]);
	              }
	              return ans;
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

	        int query[] = getArr(read.readLine());
	        int nums[] = getArr(read.readLine());
	        
	        int ans[] = nextGreaterElement(nums, query);

	        int n = ans.length;

	        System.out.println(n);
	        for(int e: ans){
	            System.out.println(e);
	        }
	        
	    }
	}

