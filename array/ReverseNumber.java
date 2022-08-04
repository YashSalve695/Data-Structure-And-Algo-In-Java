package Array;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		while(n != 0) {
			int rem = 0;
			int rev = 0;
			
			rem = n % 10;
			rev = rev*10 + rem;
			n = n/10;
			
			System.out.print(rev);
		}
         
	}

}
