package Recursion;

import java.util.Scanner;

public class MaximumNumberAfterKSwaps {
	
	
	public static String swap(String str,int i,int j) {
		
		char ith = str.charAt(i);
		char jth = str.charAt(j);
		
		String left = str.substring(0,i);
		String middle = str.substring(i + 1,j);
		String right = str.substring(j + 1);
		
		return left + jth + middle + ith + right;
	}
	
	 static String max; 
	public static void FindMax(String str,int k) {
		
		if(Integer.parseInt(str) > Integer.parseInt(max)) {
			max = str;
		}
		if(k == 0) {
			return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = i + 1; j < str.length(); j++) {
				if(str.charAt(j) > str.charAt(i)) {
					String swapped = swap(str,i,j);
					FindMax(swapped,k - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		max = str;
		FindMax(str,k);
		System.out.println(max);
		

	}

}
