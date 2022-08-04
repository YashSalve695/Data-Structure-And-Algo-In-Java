package Array;

import java.util.Scanner;

public class ArrayIndex {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int index = 0;
            int data = sc.nextInt();
            for(int i = 0; i < arr.length; i++) {
            	if(arr[i] == data) {
            		index = arr[i];
            		
            		break;
            		
            	}
            	System.out.println(index);
            }
	}

}
