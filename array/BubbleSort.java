package Array;

//import java.util.Scanner;

//import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		
		
		int arr[] = {23,1,4,66,9};
		int n = arr.length;
			
			 for(int i = 0; i < n - 1; i++) {
				 for(int j = 0; j < n - 1; j++) {
		
					 boolean sorted = true;
					 if(arr[j + 1] < arr[j]) {
						 
						 int temp = arr[j + 1];
						 arr[j + 1] = arr[j];
						 arr[j] = temp;
						 
						 sorted = false;
						 
						 }
				 if(sorted)break;
				 
				 for(int item:arr) {
					 System.out.print(item +"  ");
				 }
		
			System.out.println();	 
			 }
		 

		
		 }
		
	   }
	
}