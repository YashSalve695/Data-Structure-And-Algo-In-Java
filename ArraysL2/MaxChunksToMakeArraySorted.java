package ArraysL2;

import java.util.*;

public class MaxChunksToMakeArraySorted {

	  public static int maxChunksToSorted(int[] arr) {
	       
		  int max = 0;
		  int count = 0;
		  
		  for(int i = 0; i < arr.length; i++) {
			  max = Math.max(arr[i], max);
			  // Remove max from arr and max.
			  
			  if(i == max) {
				  count++;
			  // If index is equal to our max 
			  // then increase the count. 	  
			  }
		  }
		  return count;
	    }

	    
	    public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int[] arr = new int[n];

	        for(int i = 0; i < n; i++) {
	            arr[i] = scn.nextInt();
	        }

	        int res = maxChunksToSorted(arr);
	        System.out.println(res);
	    }

}
