package Array;

import java.util.Scanner;

public class StockBuyAndSell {
	
	public static int Maxprofit(int a[]) {
		
		int MaxProfit = 0;
		int MinProfit = a[0];
		/**  index of first element */
		
		for(int i = 0; i < a.length; i++) {
			MinProfit = Math.min(MinProfit, a[i]);
			/** compare minimum of current and next element */
			
			if(a[i] > MinProfit) {
				MaxProfit = Math.max(MaxProfit, a[i] - MinProfit);
			}
			
		}
		return MaxProfit;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int res = Maxprofit(arr);
		 System.out.println(res);
		
	}
    
}
