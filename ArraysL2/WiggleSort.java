package ArraysL2;

import java.util.Scanner;

public class WiggleSort {
	
	// Odd number = 1 3 5 ....
	// Even number = 2 4 8...
	
	/* PRINT FUNCTION **/ 
	public static void print(int arr[]) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	/** SWAP FUNCTION */
	public static void swap(int arr[],int right,int left) {
		
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void wiggleSort(int arr[]) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(i % 2 == 0) { /** EVEN CONDITION */
				if(arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			} else { /** ODD CONDITON */
				if(arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
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
	
       wiggleSort(arr);
       print(arr);
	}    
}

