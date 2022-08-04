package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
	
	/**
	 * PRINT THE INSTRUCTION TO MOVE THE DISKS.
	 * FROM TOWER 1 TO TOWER 2 USING TOWER 3.
	 * 1 MOVE 1 DISKS AT A TIME.
	 * NEVER PLACE A SMALLER DISK UNDER A LARGER DISK.
	 * YOU CAN ONLY MOVE A DISK AT THE TOP. 
	 */
	
	public static void toh(int n,int t1,int t2,int t3) {
		
		if(n == 0) {
			return;  // BASE CASE
		}
		/**
		 THIS WILL PRINT THE INSTRUCTION TO MOVE "n - 1" DISKS
		 FROM T1 TO T3 USING T2 
		 */
		toh(n - 1,t1,t3,t2);
		System.out.println(n + "[" + t1 + " -> " + t2 + "]");
		toh(n - 1,t3,t2,t1);
	}

	public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          
          int tower1 = sc.nextInt();
          int tower2 = sc.nextInt();
          int tower3 = sc.nextInt();
          
          toh(n,tower1,tower2,tower3);
 	}

}
