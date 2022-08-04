package DynamicProgramming;.

public class TargetSumSubsets {
	
	 public static int findTargetSumWays(int[] nums, int target) {
		 
		 boolean dp[][] = new boolean[nums.length + 1][target + 1];
		 
		 for(int row = 0; row < dp.length; row++) {
			 for(int col = 0; col < dp[0].length; col++) {
				 
				 if(row == 0 && col == 0) {
					 dp[row][col] = true;
					 
				 } else if(row == 0) {
					dp[row][col] = false;
					
				 } else if(col == 0) {
					 dp[row][col] = true;
					 
				 } else {
					 if(dp[row - 1][col] == true) { /** UP */
						 dp[row][col] = true;
						 
					 } else {
						 int val = nums[ row - 1];
						  if(col >= val) {
							  if(dp[row - 1][col - val] == true){
								dp[row][col] = true;  
							  }
						  }
					 }
				 }
			 }
		 }
	        
	    }

	public static void main(String[] args) {
		
		Scanner sc = 

	}

}
