package forloops;

import java.util.Scanner;

public class factorial {
	
	public static int Factorial(int n) {
		
		if(n == 1) {
			return 1;
		}
		int fact = Factorial(n - 1);
		return n * fact;
	}

	public static void main(String[] args) {
	
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      
      int res = Factorial(n);
       System.out.println(res);
	 }
	}



