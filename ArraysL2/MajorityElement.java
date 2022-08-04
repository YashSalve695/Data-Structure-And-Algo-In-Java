package ArraysL2;

import java.util.Scanner;

public class MajorityElement {
	
	public static int validElement(int arr[]) {
		
		int value = arr[0];
		// Initial value will be value of "0" index.
		
		int count = 1;
		// Count will be "1" initially.
		
		for(int i = 1; i < arr.length; i++) {
		// iterate in the array from index 1,because we have initially declare arr[0] as
	    // our majority element.
			
			if(value == arr[i]) {
				count++;
	    // If current value and value in array while iterating is equal than increase the count.
				
			} else {
				count--;
		// If previous value and current value is not equal than decrease the count.
				
			}
			
			if(count == 0) {
				value = arr[i];
				count = 1;
		// And if count becomes zero,then which ever value we are at current 
	    // then that is the value currently.And count becomes zero.			
			}
		}
		return value;
	   // And at last return that current value.	
	}
	
	public static void  majorityElement(int arr[]) {
		
		int count = 0;
		
		int value = validElement(arr);
		// Function call the value ,which we think is our majority element.
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				count++;
		// Search that value in array,To see if that value is present
		// till end.If that value present in the array then increase the count.
				
			}
		}
			if(count > arr.length / 2) {
				System.out.println(value);
		// If the count is greater than n/2 that that value is our majority element.		
			} else {
				System.out.println("Majority Element does not exists");
		}
	}

	public static void main(String[] args) {
           
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
        majorityElement(arr);

	}

}
