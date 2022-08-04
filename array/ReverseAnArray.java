package array;

import java.util.*;

//import Algorithm.BinarySearch;

public class ReverseAnArray {
	
	
	public static void Reverse(int[] arr, int i, int j) {
	
	 i = 0;
	 j = arr.length - 1;
	while(i < j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		i++;
		j--;
	}
	
	
	}
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
    int n = sc.nextInt();
    int arr[] = new int[n];
     for(int i = 0; i < n; i++) {
    	 arr[i] = sc.nextInt();
     }
     Reverse(arr, 0, arr.length - 1);
     printArray(arr);
	}

	public static void printArray(int a[]) {
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
		
	}


