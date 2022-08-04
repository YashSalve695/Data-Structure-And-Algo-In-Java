package forloops;

import java.util.Scanner;

public class palindromenumber {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();
		 
		 int temp = n;
		  int reversedNumber = 0;
			
			 while(temp > 0) {
				
				   int lastDigit = temp % 10;
				   reversedNumber = reversedNumber * 10 + lastDigit;
				   temp /= 10;
		 }
		
		if(reversedNumber == n) {
			 System.out.println(n +" number is palindrome");
		} else {
			System.out.println(n + "number is not palindrome");
		}
	
		
	}
}

	


