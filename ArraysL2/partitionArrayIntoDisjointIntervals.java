package ArraysL2;

import java.util.*;

public class partitionArrayIntoDisjointIntervals {

	 public static int partitionDisjoint(int[] arr) {
		    
		 int leftmax = arr[0];
		 // First element in a array.
		 
		 int greater = arr[0];
		 // First element in a array.
		 
		 int ans = 0;
		 
		 for(int i = 1; i < arr.length; i++) {
		// Loop will run from first index.
			 
			 if(arr[i] > greater) {
		// if element in array is greater than our 
		// greater element.		 
				 greater = arr[i];
	    // Than make that our greater element.			 
				 
			 } else if(arr[i] < leftmax) {
		// And if the element in arr is less than leftmax		 
				 leftmax = greater;
		// Than make that element in our arr is equal to leftmax.		 
				  ans = i;
		// And make that index our ans.		  
			 }
		 }
		 return ans + 1;
		  }

		 
		  public static void main(String[] args) {
		    Scanner scn = new Scanner(System.in);
		    int n = scn.nextInt();
		    int[] arr = new int[n];

		    for (int i = 0; i < n; i++) {
		      arr[i] = scn.nextInt();
		    }

		    int len = partitionDisjoint(arr);
		    System.out.println(len);
		  }

}
