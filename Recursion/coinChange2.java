package Recursion;

import java.util.Scanner;

public class coinChange2 {
	
	public static void coinchange2(int i,int []coins,int amtsf,int tamt,
			String asf) {
	
		if(i == coins.length) {
			if(amtsf == tamt) {
				System.out.println(asf + ".");
			}
			return;
		}
		
		for(int j = tamt / coins[i]; j >= 1; j--) {
			String part = "";
			for(int k = 0; k < j; k++) {
				part += coins[i] + "-";
			}
			coinchange2(i + 1,coins,amtsf + coins[i] * j,tamt,asf + part);
		}
		coinchange2(i + 1,coins,amtsf,tamt,asf);
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int coins[] = new int[n];
		 for(int i = 0 ; i < n; i++) {
			 coins[i] = sc.nextInt();
		 }
		 int amt = sc.nextInt();
		 coinchange2(0,coins,0,amt,"");
	}

}
