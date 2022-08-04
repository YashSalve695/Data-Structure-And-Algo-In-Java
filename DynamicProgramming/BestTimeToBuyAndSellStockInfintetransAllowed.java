package DynamicProgramming;

import java.util.*;

public class BestTimeToBuyAndSellStockInfintetransAllowed {
	
/**	

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed 
    infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before 
       opening another transaction (another buy)
       
9
11
6
7
19
4
1
6
18
4

30       

*/
	
	private static int Infinte_times(int arr[]) {
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = sc.nextInt();
		 }
		 
		 int ans = Infinte_times(arr);
		 System.out.println(ans);
		

	}

}
