package HashMaps;

import java.util.*;

public class PairsWithGivenSumInTwoSortedMatrices {
	
	private static int CountPairsSum(int matrix1[][], int matrix2[][], int target) {
		
		int countPairsum = 0;
		
		/** Put all the element in matrix1 in hashmap */
		HashMap<Integer, Integer> map = new HashMap<>();
		 for(int row = 0; row < matrix1.length; row++) {
			 for(int col = 0; col < matrix1[0].length; col++) {
				 int values = matrix1[row][col];
				 map.put(values, map.getOrDefault(values, 0) + 1);
			 }
		 }
		 for(int row = 0; row < matrix2.length; row++) {
			 for(int col = 0; col < matrix2[0].length; col++) {
				 int val = matrix2[row][col];
				 int complement = target - val;
				 
				 if(map.containsKey(complement)) {
					 countPairsum += map.get(complement);
				 }
			 }
		 }
		 return countPairsum;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num1[][] = new int[n][n];
		 for(int i = 0; i < n; i++) {
			 for(int j = 0; j < n; j++) {
				 num1[i][j] = sc.nextInt();
			 }
		 }
		 int num2[][] = new int[n][n];
		 for(int i = 0; i < n; i++) {
			 for(int j = 0; j < n; j++) {
				 num2[i][j] = sc.nextInt();
			 }
		 }
		 int target = sc.nextInt();
		 
		 int countPair = CountPairsSum(num1, num2, target);
		  System.out.println(countPair);
	}

}


/**

3
1 5 6
8 10 11
15 16 18
2 4 7
9 10 12
13 16 20
21

*/