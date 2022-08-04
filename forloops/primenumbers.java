package forloops;

import java.util.Scanner;

public class primenumbers {

	public static void main(String[] args) {
		
		Scanner sc = New scanner(System.in);
		int n = sc.nextInt();
		
		Boolean isPrime = true;
		  for(int i = 2; i < n; i++) {
			  if(n % i == 0) {
				  isPrime = false;
				    break;
			if(n < 2) {
				isPrime = false;
				System.out.println("isPrime" + "isPrime");
			}
			  }
		  }
	}
	

}
