package ArraysL2;

import java.util.Scanner;

public class MaxChunksToMakeArraySorted2 {

	 public static int maxChunksToSorted(int[] arr) {
	       
		  int rmin[] = new int[arr.length];
		  rmin[arr.length] = Integer.MAX_VALUE;
		   for(int i = arr.length - 1; i >= 0; i--) {
			   rmin[i] = Math.min(arr[i], rmin[i + 1]);
		   }
		   int leftmax = Integer.MIN_VALUE;
		    int count = 0;
		    for(int i = 0; i < arr.length; i++) {
		    	leftmax = Math.min(leftmax, arr[i]);
		    	if(leftmax <= rmin[i + 1]) {
		    		count++;
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
