package Array;

import java.util.Scanner;

public class PrintAllSubarray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
//		START FROM I FIRST ELEMENT OF ARRAY
				for(int i = 0; i < arr.length; i++) {
//				START FROM I TILL J 
					for(int j = i; j < arr.length; j++) {
//					TO PRINT ALL ELEMENTS
						for(int k = i; k <= j; k++) {
							System.out.print(arr[k] + " ");
						}
						System.out.println();
					}
				}
		
		
	}

}
