package Recursion;

import java.util.Scanner;

public class CoinChangePro {
	
	public static void coinChange(int i,int []coins,int amtsf,int tamt,
			String asf) {
		
		if(i == coins.length) {
			if(amtsf == tamt) {		
				System.out.println(asf + ".");
			}
			return;
		}
		coinChange(i + 1,coins,amtsf + coins[i],tamt,asf + coins[i] + "-");
		coinChange(i + 1,coins,amtsf,tamt,asf);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int coins[] = new int[n];
		for(int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		int amt = sc.nextInt();
		coinChange(0,coins,0,amt,"");
	}

}
