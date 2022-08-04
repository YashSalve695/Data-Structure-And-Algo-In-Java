package ArraysL2;

import java.util.Scanner;

public class TransposeOfMatrixMintoN {
	
	public static int[][] transpose(int [][]matrix){
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		int result[][] = new int[col][row];
		
		 for(int i = 0; i < col; i++) {
			 for(int j = 0; j < row; j++) {
				 result[i][j] = matrix[j][i];
			 }
		 }
		 return result;
	}

	public static void main(String[] args) {
		
		 Scanner scn = new Scanner(System.in);
		    int n = scn.nextInt();
		    int m = scn.nextInt();

		    int[][] matrix = new int[n][m];

		    for (int i = 0; i < n; i++) {
		      for (int j = 0; j < m; j++) {
		        matrix[i][j] = scn.nextInt();
		      }
		    }

		    int[][] res = transpose(matrix);

		    for (int i = 0; i < res.length; i++) {
		      for (int j = 0; j < res[0].length; j++) {
		        System.out.print(res[i][j] + " ");
		      }
		      System.out.println();
		    }
		  }

}
 