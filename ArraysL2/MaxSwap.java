package ArraysL2;

import java.util.*;

public class MaxSwap {
	
	public static void swap(char arr[], int i , int j) {
		
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static String max_Swap(String num) {
		
		char arr[] = num.toCharArray();
		
		/** prepare last index of digit*/
        /** last occurence of each digit */
		int last_index[] = new int[10];
		 for(int i = 0; i < num.length(); i++) {
			 int digit = arr[i] - '0';
			 last_index[digit] = i;
		 }
		 
		/**figure out position for swapping */
		 boolean flag = false;
		 for(int i = 0; i < arr.length; i++) {
			 int digit = arr[i] - '0';
			 for(int j = 9; j > digit; j--) {
				 if(i < last_index[j]) {
					 swap(arr, i, last_index[j]);
					 flag = true;
					 break;
				 }
			 }
			 if(flag == true) {
				 break;
			 }
		 }
		 
		 /** prepare ans in form of string*/
		 String res = "";
		  for(int i = 0; i < arr.length; i++) {
			  res += arr[i];
		  }
		 
		return res;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String ans = max_Swap(str);
		 System.out.println(ans);
		
	}

}
