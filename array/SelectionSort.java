package Array;

import java.util.*;

public class SelectionSort {
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static boolean isSmaller(int arr[],int i,int j) {
		
	//	System.out.println(" Comparing   " + arr[i] + " and " + arr[j]);
		    if(arr[i] < arr[j]) {
		    	return true;
		    } else {
		    	return false;
		}	
	}
	
	public static void swap(int arr[],int i,int j) {
		
	//	System.out.println("  Swapping  " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void selection(int arr[]) {
		
		int n = arr.length;
		 for(int i = 0; i < n - 1; i++) {
			 int minindx = i;
			 for(int j = i + 1; j < n; j++) {
				 if(isSmaller(arr,j,minindx)) {
					 minindx = j;
				 }
			 }
			 swap(arr,i,minindx);
		 }
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = sc.nextInt();
		 }
		 selection(arr);
		 print(arr);
		
	}
}
