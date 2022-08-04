package Recursion;

import java.util.Scanner;

public class CrosswordPuzzle {
	
	public static boolean canPlaceHorizontally(char[][] arr,String word,
			int i,int j) {
		
		if(j - 1 >= 0 && arr[i][j - 1] != "+") {
			return false;
		} else if(j + word.length() <= arr[0].length && arr[i][j + word.length()] != "+") {
			return false;
		}
		                                                       
		
	}
	
	
	public static void solve(char[][] arr,String []words,int vidx) {
		
		String word = words[vidx];
		//first word which we have pass to allocated.
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				// placed the word in all possible vacant position.
				if(arr[i][j] == "-" || arr[i][j] == word.charAt(0)) {
					if(canPlaceHorizontally(arr,word,i,j)) {
						placeHorizontally(arr,word,i,j);
						solve(arr,words,vidx + 1);
						unplaceHorizontally(arr,word,i,j);
					}
					if(canPlaceVertically(arr,word,i,j)) {
						placeVertically(arr,word,i,j);
						solve(arr,words,vidx + 1);
						unplaceVertically(arr,word,i,j);
					}
				}
			}
		}
	}
	
	public static void print(char[][] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char [][]arr = new char[10][10];
		 for(int i = 0; i < arr.length; i++) {
			 String str = sc.next();
			 arr[i] = str.toCharArray();
			 // Converts this string to a new character array.
		 }
		 int n = sc.nextInt();
		 String []words = new String[n];
		 for(int i = 0; i < words.length; i++) {
			 words[i] = sc.next();
		 }
		 solve(arr,words,0);

	}

}
