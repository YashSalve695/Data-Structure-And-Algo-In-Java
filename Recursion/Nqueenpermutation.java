package Recursion;

import java.util.*;

public class Nqueenpermutation {
	
	public static boolean isQueensafe(int chess[][],int row,int col) {
		
		for(int i = row,j = col; i >= 0; i--) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
		for(int i = row,j = col; i < chess.length; i++) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
		for(int i = row,j = col; j >= 0; j--) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
		for(int i = row,j = col; j < chess.length; j++) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
		for(int i = row,j = col; i >= 0 && j >= 0; i--,j--) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
		for(int i = row,j = col; i >= 0 && j < chess.length; i--,j++) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
		for(int i = row,j = col; i < chess.length && j < chess.length; i++,j++) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
		for(int i = row,j = col; i < chess.length && j >= 0; i++,j--) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void nqueen(int qsf,int tq,int chess[][]) {
		
		if(qsf == tq) {
			for(int i = 0; i < chess.length; i++) {
				for(int j = 0; j < chess.length; j++) {
					if(chess[i][j] == 0) {
						System.out.print("-\t");
					} else {
						System.out.print("q" + chess[i][j] + "\t");
					}
					
				}
				System.out.println();
				
			}
			System.out.println();
			return;
		}
		
		for(int cell = 0; cell < chess.length*chess.length; cell++) {
			int row = cell / chess.length;
			int col = cell % chess.length;
			
			if(chess[row][col] == 0 && isQueensafe(chess,row,col)) {
				chess[row][col] = qsf + 1;
				nqueen(qsf + 1,tq,chess);
				chess[row][col] = 0;
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int chess[][] = new int[n][n];
		
		nqueen(0,n,chess);
	}

}
