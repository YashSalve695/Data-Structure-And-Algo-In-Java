package forloops;

import java.util.Scanner;

public class power {
	
	private static int power(int n) {
		
		int res = (int)Math.sqrt(n);
		
		return res;
		
	}

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		 int a = sc.nextInt();
	//	 int b = sc.nextInt();
		 
		 int ans = power(a);
		 System.out.println(ans);
		  
		
	}

}
