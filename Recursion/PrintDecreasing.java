package Recursion;

import java.util.Scanner;

public class PrintDecreasing {
	
	//public static void PD(int n) {
		
	//	if(n == 0) { // BASE CASE
		//	return;
	//	}
	//	System.out.println(n);
	//	PD(n - 1);
	//}
	
	//public static void PI(int n) {
	//	if(n == 0) {
	//		return;
	//	}
	//	PI(n - 1);
	//	System.out.println(n);
//	}
	
	public static void PDI(int n) {
		
		if(n == 0) {
			return;
		}
		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
	}

	public static void main(String[] args) {

   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   
    //   PD(n);
     //  PI(n);
       PDI(n);
	}

}
