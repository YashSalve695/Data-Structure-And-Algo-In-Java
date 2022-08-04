package ArraysL2;

import java.util.*;

public class SieveOfEratosthenes {
	
	public static void printPrimeUsingSieve(int n) {
		
		boolean prime[] = new boolean[n + 1];// 0 based indexing.
		
		Arrays.fill(prime, true);
		// Marked all the elements in the array
		// true intially.
		
		for(int i = 2; i * i < prime.length; i++) {
		// i will start from index 2,And it will increase
	    // by 2 * i.		
			if(prime[i] == true) {
		// If elements in prime is true.		
				for(int j  = i + i; j < prime.length; j += i) { 			
					prime[j] = false;
				}
			}
		}
		for(int i = 2; i < prime.length; i++) {
			if(prime[i] == true) {
				System.out.print(i + " ");
		// if element in prime is true,print i.		
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		printPrimeUsingSieve(n);
		
	}

}
