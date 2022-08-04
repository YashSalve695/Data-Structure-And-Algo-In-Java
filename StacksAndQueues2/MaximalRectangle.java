package StacksAndQueues2;

import java.util.*;
import java.io.*;

public class MaximalRectangle {
	
public static int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();
        
        st.push(-1);
        int maxArea = 0;
        
        for(int i=0;i<=heights.length;i++){
            int val = i==heights.length ? 0 : heights[i];
            
            while(st.peek() != -1 && heights[st.peek()] >= val){
                int rm = i;
                int h = heights[st.pop()];
                int lm = st.peek();
                maxArea = Math.max(maxArea, h*(rm-lm-1));
            }
            
            st.push(i);
        }
        
        return maxArea;
    }

	 public static int maximalRectangle(int[][] arr) {           
	        
		 int height[] = new int[arr[0].length];
		 
		  for(int i = 0; i < arr[0].length; i++) {
			  height[i] = arr[0][i];
		  }
		  int area = largestRectangleArea(height);
		   for(int i = 1; i < arr.length; i++) {
			   for(int j = 0; j < arr[0].length; j++) {
				   if(arr[i][j] == 1) {
					   height[j]++;
				   } else {
					   height[j] = 0;
				   }
			   }
			   area = Math.max(area, largestRectangleArea(height));
		   }
		   return area;
	    }

	    public static void main(String[] args) throws Exception {
	        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

	        int row = Integer.parseInt(read.readLine());
	        int col = Integer.parseInt(read.readLine());
	        
	        int bmat[][] = new int[row][col];

	        for(int i=0;i<row;i++){
	            String s = read.readLine();
	            for(int j=0;j<col;j++){
	                bmat[i][j] = s.charAt(j)-'0';
	            }
	        }

	        int result = maximalRectangle(bmat);
	        System.out.println(result);
	        
	    }

}
