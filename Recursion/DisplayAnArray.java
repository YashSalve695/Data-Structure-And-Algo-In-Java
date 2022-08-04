package Recursion;

import java.util.Scanner;

public class DisplayAnArray {

	public static void DA(int []n,int index) {
		
		if(index == n.length) {
			return;
		}
		
		System.out.println(n[index]);
		DA(n,index + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = sc.nextInt();
		 }
		 DA(arr,0);

	}

}
