package Recursion;

import java.util.*;

public class Factorial {
	
	public static int factorial(int n) {
		
		if(n == 1) {
			return 1;
		}
		
		int fact1 = factorial(n - 1);
		int fn = fact1 * n;
		return fn;
	}

	public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int fact = factorial(n);
    System.out.println(fact);
	}

}
