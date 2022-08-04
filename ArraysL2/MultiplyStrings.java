package ArraysL2;

import java.util.*;

public class MultiplyStrings {
	
	public static String multiply(String num1, String num2) {
		
		/** If any one value is zero than directly return
		    zero */
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		
		int len = num1.length() + num2.length();
		int res[] = new int[len];
	
	    int carry = 0;	
		int pf = 0;/** power factor */
		
		int i = num2.length() - 1;
		
		while(i >= 0) {
			
			int ival = num2.charAt(i) - '0';
			i--;
			 
			int fill_result = res.length - 1 - pf;
			int j = num1.length() - 1;
			
			while(j >= 0 || carry != 0) {
				
		int jval = j >= 0 ? num1.charAt(j) - '0' : 0;
				j--;
				
		int product = ival * jval + carry + res[fill_result];
		 		
		  res[fill_result] = product % 10;
		  carry = product / 10;
		  fill_result--;
			}
			pf++;
		}
		  
    /** Management of leading zero using general method */
		String str = "";
		
		boolean flag = false;
		
		for(int val : res) {
			if(val == 0 && flag == false) {
				continue;
			} else {
				flag = true;
				str += val;
			}
		}
		return str;
	}

	public static void main(String[] args) {
		
     Scanner sc = new Scanner(System.in);
     
     String s1 = sc.next();
     String s2 = sc.next();
     
     String ans = multiply(s1, s2);
      System.out.println(ans);
	}

}
