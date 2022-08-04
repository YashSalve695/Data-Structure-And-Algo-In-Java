package Array;

import java.util.Scanner;

public class IndexOfNumber {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int data = sc.nextInt();
		int index = -1;
		 for(int i = 0; i < arr.length; i++) {
			 if(arr[i] == index) {
				 index = i;
				 break;
			 }
			 System.out.print(index);
		 }
		
		
		
		
	}

}
