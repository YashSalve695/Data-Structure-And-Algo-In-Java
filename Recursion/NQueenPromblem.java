package Recursion;

import java.util.Scanner;

public class NQueenPromblem {
	
	public static void PrintNQueen(int[][] chess,String qsf,int row) {
		
		if(row == chess.length) {
			System.out.println(qsf);
			return;
		}
		for(int col = 0; col < chess.length; col++) {
			if(isitSafe(chess,row,col) == true) {
			chess[row][col] = 1;
			PrintNQueen(chess,qsf + row + "-" + col + ",",row + 1);
			chess[row][col] = 0;	
			}
		}
		}
	public static boolean isitSafe(int[][] chess,int row,int col) {
		
		for(int i = row - 1,j = col; i >= 0; i--) {
			if(chess[i][j] == 1) {
				return false;
			}
		}
	for(int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
		if(chess[i][j] == 1) {
			return false;
		}
	}
	for(int i =  row - 1,j = col + 1; i >= 0 && j < chess.length; i--,j++) {
		if(chess[i][j] == 1) {
			return false;
		}
	}
	return true;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		PrintNQueen(arr,"",0);
	}

}
