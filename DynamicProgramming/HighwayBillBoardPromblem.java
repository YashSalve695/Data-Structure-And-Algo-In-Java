package DynamicProgramming;

import java.util.*;

public class HighwayBillBoardPromblem {
	
	
	/**
	
20 miles
5 boards
6 8 12 14 16 where boards are situated
5 8 5 3 1 and each board revenue
3 gap required

14
	
	
	*/
	public static int solve(int miles, int boards[], int revenue[], int gap) {
		
		int dp[] = new int[miles + 1];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		 for(int mil = 0; mil < boards.length; mil++) {
			 map.put(boards[mil], revenue[mil]);
		 }
		 
		 dp[0] = 0;
		  for(int i = 1; i <= miles; i++) {
			  if(map.containsKey(i) == false) {
				  dp[i] = dp[i - 1];
				  
			  } else {
				  
				  int boards_not_installed = dp[i - 1];
				  int boards_installed = map.get(i);
				  
				  if(i >= gap + 1) {
					  boards_installed += dp[i - gap - 1];
				  }
				  
				  dp[i] = Math.max(boards_not_installed, boards_installed);
			  }
		  }
		  System.out.println(map);
		 return dp[miles];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int miles = sc.nextInt();
		int billboards = sc.nextInt();
		
		int bill_boards[] = new int[billboards];
		int revenue[] = new int[billboards];
		
		for(int i = 0; i < billboards; i++) {
			bill_boards[i] = sc.nextInt();
		}
		
		for(int j = 0; j < billboards; j++) {
			revenue[j] = sc.nextInt();
		}
		
		int gap = sc.nextInt();
		int ans = solve(miles, bill_boards, revenue, gap);
		 System.out.println(ans);

	}

}
