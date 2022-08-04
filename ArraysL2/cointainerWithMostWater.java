package ArraysL2;

import java.util.Scanner;

public class cointainerWithMostWater {
	
	public static void printarray(int arr[]) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int mostWater(int heights[]) {
		
		int water = 0;
		// To store the water.Which will be our answer.
		
		int i = 0;
		// i will be on starting index.
		
		int j = heights.length - 1;
		// j will be on last index of array.
		
		   while(i < j) {
	   // Loop will run till i will be less than j.
			   
		      int width = j - i;
	   // To know the width, we can minus index of j minus i.
		      
		      int height = Math.min(heights[i],heights[j]);
	   // To know the height,remove the minimum value of i and j.	      
		      
		      water = Math.max(water, height * width);
	   // And to know the where the max water is store.	      
		      
		      if(heights[i] < heights[j]) {
		    	  i++;
	   // If the value of i is less than j,increment i.
		    	  
		      }else {
		    	  j--;
	   // And if the value of j is smaller than i,increment j.   	  
		      }
	   }
		   return water;
	  // Return the total water store.	   
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		  for(int i = 0; i < n; i++) {
			  arr[i] = sc.nextInt();
		  }
		  int res = mostWater(arr);
		System.out.println(res);
	}

}
