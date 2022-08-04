package DynamicProgramming;

import java.util.*;

public class CountEncodings {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
		  
		  String str = sc.next();
		  
		  int dp[] = new int[str.length()];
		  dp[0] = 1; /** at zero index there is always 1 encodings */
		  
		  for(int i = 1; i < dp.length; i++) {
			  
			  if(str.charAt(i - 1) == '0' && str.charAt(i) == '0') {/** Case 1*/
				  dp[i] = 0;
				  
			  } else if(str.charAt(i - 1) == '0' && str.charAt(i) != '0') {/** Case 2 */
				  dp[i] = dp[i - 1];
				  
			  } else if(str.charAt(i - 1) != '0' && str.charAt(i) == '0') {/** Case 3 */
				  if(str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
					  dp[i] = (i >= 2 ? dp[i - 2] : 1); /** if the len of string is 2 */
				  } else {
					  dp[i] = 0;
				  }
				  
			  } else {
//				
				  if(Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
					dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1); /** if the len of string is 2 */ 
				  } else {
					  dp[i] = dp[i - 1];
				  }
			  }
		  }
		  System.out.println(dp[str.length() - 1]);
	}

}
