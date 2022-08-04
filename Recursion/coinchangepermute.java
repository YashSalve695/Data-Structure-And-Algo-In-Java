package Recursion;

import java.util.Scanner;

public final class coinchangepermute {
	
	public static void coinpermute(int coins[],int amtsf,int tamt,String asf,
			boolean[] used) {
		
		if(amtsf > tamt) {
			return;
		}else if(amtsf == tamt) {
			System.out.println(asf);
			return;
		}
		
		for(int i = 0; i < coins.length; i++) {
			if(used[i] == false) {
				used[i] = true;
		coinpermute(coins,amtsf + coins[i],tamt,asf + coins[i] + "-",used);
		        used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int coins[] = new int[n];
		for(int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		int amt = sc.nextInt();
		boolean used[] = new boolean[coins.length];
		coinpermute(coins,0,amt,"",used);
	}


	

}
