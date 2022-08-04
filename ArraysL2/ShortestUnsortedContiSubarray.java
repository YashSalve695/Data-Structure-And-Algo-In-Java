package ArraysL2;

import java.util.Scanner;

public class ShortestUnsortedContiSubarray {
	
	public static int findunsortedsubarray(int arr[]) {
		
		int end = -1;
		// Currently marked as -1;/*Default value*/
		
		int max = arr[0];
		// Currently our max is element present on '0' index of array.
		
		for(int i = 1; i < arr.length; i++) {
			if(max > arr[i]) {
				end = i;
		// Loop will run from '1' index as,we have taken '0' element
		// as our max.(as default)
		// Then we iterate in the array,And if we find that our
		// max is greater that our currently element in the array.
		// Then end will be index of that current element.
				
			} else {
				
				max = arr[i];
		// If not then max will be our current element.		
			}
		}
		int start = 0;
		// start will be 0.
		int min = arr[arr.length - 1];
		// Min value will be currently element present 
		// at last index of the array.
		
		for(int i = arr.length - 2; i >= 0; i--) {
			if(arr[i] > min) {
				start = i;
		// Loop will iterate from second last element 
		// of the array. 
		// And if the current element in the array is greater
		// than min, then index of that element will be 
		// our start.		
			} else {
				
				min = arr[i];
		// If the current element is smaller than,
		// then that element will be our min.		
			}
		}
		return end - start + 1;
	   // At the end return end - start plus one.	
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		  for(int i = 0; i < n; i++) {
			  arr[i] = sc.nextInt();
		  }
		
		int res = findunsortedsubarray(arr);
		 System.out.println(res);
	}

}
