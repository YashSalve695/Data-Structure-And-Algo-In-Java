package Recursion;

import java.util.*;

public class GoldMine {
	
	public static void travelAndcollectgold(int arr[][],int i,int j,
		               boolean visited[][],ArrayList<Integer> bag ) {
		
		// BASE CASE
		if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length ||
				arr[i][j] == 0 || visited[i][j] == true) {
			return;
		}
		
		visited[i][j] = true;
		// Visit every element in the matrix except "0" and
		// make it visited.
		bag.add(arr[i][j]);
		// And,add it in the bag.
		
		//RECURSIVE CALLS
		travelAndcollectgold(arr,i - 1,j,visited,bag);
		// To go in top direction.
		travelAndcollectgold(arr,i + 1,j,visited,bag);
		// To go in down direction.
		travelAndcollectgold(arr,i,j - 1,visited,bag);
		// To go in left direction.
		travelAndcollectgold(arr,i,j + 1,visited,bag);
        // To go in right direction.		    
	  
	}
	    
	
	static int max = 0;
	public static void GetMaxGold(int [][]arr) {
		
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		// Make every row and col visited.
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
        // From which position we have to start.
			if(arr[i][j] != 0 && visited[i][j] == false) {
		// To see if element on "i" and "j" position are not
		// equal to zero and are not visited ,then move forward.
				
		ArrayList<Integer> bag = new ArrayList<>();
		// To store the visited element in the box.
		
		travelAndcollectgold(arr,i,j,visited,bag);
		 // Function to move in every direction in a matrix.
		
		int sum = 0;
		for(int val : bag) { // For each loop.
			sum += val;
		// To get all the elements in the bag.And then add all the elements.
		}
		if(sum > max) {
			max = sum;
		// If the sum of all the elements in the bag is greater
		// than max then return sum.	
		          }
			   }
			}
		}
	}
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		 for(int i = 0; i < arr.length; i++) {
			 for(int j = 0; j < arr[0].length; j++) {
				 arr[i][j] = sc.nextInt();
			 }
		 }
		 GetMaxGold(arr);
	System.out.println(max);
}

}
