package DynamicProgramming;

import java.util.*;

public class CountBinaryStringsWithNoConsecutive0 {
	
	public static int count_binary_strings(int n) {
		
		int dpzero[] = new int[n + 1];
		int dpone[] = new int[n + 1];
		
		dpzero[1] = 1;
		dpone[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			
			dpzero[i] = dpone[i - 1];
			dpone[i] = dpzero[i - 1] + dpone[i - 1];
		}
		return dpzero[n] + dpone[n];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int res = count_binary_strings(n);
		 System.out.println(res);

	}

}
