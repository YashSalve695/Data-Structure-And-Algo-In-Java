package Recursion;

import java.util.Scanner;

public class MaxArray {
	
	public static int maxArray(int arr[],int index) {
		
		if(index == arr.length) {
			return arr[index];
		}
		int misa = maxArray(arr,index + 1);
		
		if(misa > arr[index]) {
			return misa;
		} else {
			return arr[index];
		}
			
		
	}

	public static void main(String[] args) {

             Scanner sc = new Scanner(System.in);
             int n = sc.nextInt();
             int arr[] = new int[n];
              for(int i = 0; i < arr.length; i++) {
            	  arr[i] = sc.nextInt();
              }
            maxArray(arr,0);  
	}

}
