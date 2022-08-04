package forloops;

import java.util.Scanner;

public class prime {
	
	

	public static void main(String[] args) {
	
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Boolean isPrime = true;
			  
			for(int i = 2; i < n; i++) {
			     if(n % i ==0) {
			    	 
			    	 
			    	 isPrime = false;
			    	 break;
			    	 
			     }
			}
         System.out.println(n + " is" + isPrime);
		}
	   
		
	}

}
