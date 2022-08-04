package ArraysL2;

import java.util.Scanner;

public class SortArrayByParity {
	
	/** SWAP FUNCTION */
	public static void swap(int arr[], int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void sortArraybyParity(int []arr) {
		
		int i = 0;
		// i will get even elements in the array.
		
		int j = 0;
		// j will get the odd elements in the array.
		
		while(i < arr.length) {
		// Operation will execute till there are element in the array.	
			if(arr[i] % 2 == 0) {
		// If current elements present in the arr is even. 		
				swap(arr,i,j);
		// Swap it with element present at j is odd.		
				
				i++;
				j++;
		// Then increment i and j.		
			} else {
				
				i++;
		// And if the current element is odd then i will 
		// only increment not j,Because j is currently
		// at odd element.		
			}
		}
	}
	
	public static void main(String[] args) {
		
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
     
        }
      	sortArraybyParity(arr); 
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
	    }
	}
}
