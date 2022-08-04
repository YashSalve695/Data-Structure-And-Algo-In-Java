package Recursion;

import java.util.Scanner;

public class FriendsPair {
	
	public static void pairfriend(int i,int n,boolean used,
			                                String asf) {
		
		if(i > n) {
			System.out.println(counter + ".");
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean used[] = new boolean[n + 1];
		pairfriend(1,n,used,"");
	}

}
