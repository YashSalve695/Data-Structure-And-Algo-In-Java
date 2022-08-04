package StacksAndQueues2;

import java.util.*;

public class NumberOfValidSubarrays {
	
	/** BASED ON NEXT GREATER ON RIGHT */
	
	public static int ValidSubarrays(int nums[]) {
		
		Stack<Integer> st = new Stack<>();
		int ans = 0;
		
		for(int i = nums.length - 1; i >= 0; i--) {
			int val = nums[i];
			
			while(st.size() > 0 && nums[st.peek()] >= val) st.pop();
			
			int smallindex = nums.length;
			 if(st.size() > 0) {
				 smallindex = st.peek();
			
			 }
			 ans += smallindex - i;
			 st.push(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		  for(int i = 0; i < n; i++) {
			  arr[i] = sc.nextInt();
		  }
		  int res = ValidSubarrays(arr);
		   System.out.println(res);
	}

}
