package ArraysL2;

import java.util.*;

public class ReverseVowelsOfaString {
	
	public static boolean isVowel(char arr[],int indx) {
		
		char ch = arr[indx];
		
		if(ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u' ||
		   ch == 'A' || ch == 'I' || ch == 'E' || ch == 'O' || ch == 'U') {
			 return true;
		}
		return false;
	}
	
	public static void swap(char arr[], int left, int right) {
		
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		
		left++;
		right--;
	}
	
	public static String ReverseVowels(String s) {
		
		char arr[] = s.toCharArray();
		// Convert given string to character array.
		
		/** APPLY TWO POINTER APPROACH */
		
		int left = 0;
	    // Left will be at starting index.
		
		int right = arr.length - 1;
		// And right will be at last index of array.
		
		while(left < right) {
		// Operation will work till left is less than right.
			
			while(left < right && isVowel(arr,left) == false) {
				left++;
		// Iterating from left, isVowel function will check
		// if there are vowels present in the string.
		// If we find that there is a vowel present		
			}
			while(left < right && isVowel(arr,right) == false) {
				right--;
	   // Iterating from left, isVowel function will check
	   // if there are vowels present in the string.
	   // If we find that there is a vowel present				
			}
			swap(arr,left,right);
			 left++;
			 right--;
	  // If upper there is vowel present in the arr
	  // then swap that vowels with each other.		 
		}
		String str = "";
		 for(char ch : arr) {
			 str += ch;
		 }
		 return str;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		String res = ReverseVowels(str);
		System.out.println(res);
		

	}

}
