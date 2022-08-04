package DynamicProgramming;

import java.util.*;

public class PrintAllPathsOfLIS {
	
	public static class Pair {
		
		int length;
		int val;
		int index;
		String psf;
		
		Pair(int length, int val, int index, String psf){
			this.length = length;
			this.val = val;
			this.index = index;
			this.psf = psf;
		}
	}
	
	private static void Print_paths_of_LIS(int arr[]) {
		
		int dp[] = new int[arr.length];
		int max = 0;
		int overall_max = 0;
		int overall_max_index = 0;
		
		for(int index = 0; index < dp.length; index++) {
			for(int find = 0; find < index; find++) {
				
				if(arr[find] <= arr[index]) {
					if(dp[find] > max) {
						max = dp[find];
					}
				}
			}
			dp[index] = max + 1;
			 if(dp[index] > overall_max) {
				 overall_max = dp[index];
				 overall_max_index = index;
			 }
		}
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		  queue.add(new Pair(overall_max, overall_max_index, arr[overall_max_index], 
				                                          arr[overall_max_index] + ""));
		  
		  while(queue.size() > 0) {
			  
			  Pair remove = queue.removeFirst();
			  
			  for(int j= 0; j < remove.index; j++) {
				  if()
			  }
		  }
		  
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		 
		 Print_paths_of_LIS(arr);

	}

}
