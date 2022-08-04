package StacksAndQueues2;

import java.util.*;

public class TrappingRainWater {
	
	public static int trap(int height[]) {
		
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int ans = 0;
		
		 for(int i = 0; i <height.length; i++) {
			 while(st.size() > 0 && height[st.peek()] <= height[i]) {
				 
				 int rightmax = i;
				 int curr = height[st.peek()];
				 if(st.size() == 0) break;
				 int leftmax = st.peek();
				 
				 int width = rightmax - leftmax - 1;
				 ans += Math.min(height[rightmax],height[leftmax]) - curr * width;
			 }
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
		int res = trap(arr);
		 System.out.println(res);
		
	}

}
