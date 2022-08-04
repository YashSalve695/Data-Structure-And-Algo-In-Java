package Recursion;

import java.util.Scanner;

public class SodukuSolve {
	
	public static void display(int[][] board) {
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean isValid(int [][]board,int row, int col,int val) {
		
		for(int j = 0; j < board[0].length; j++) {
			if(board[row][j] == val) {
				return false;
			}
		}
		for(int i = 0; i < board.length; i++) {
			if(board[col][i] == val) {
				return false;
			}
		}
		int smi = row / 3 * 3; //
		int smj = col / 3 * 3;
		 for(int i = 0; i < 3; i++) {
			 for(int j = 0; j < 3; j++) {
				 if(board[smi + i][smj + j] == val) {
					 return false;
				 }
			 }
		 }
		 return true;
		
	}
	
	public static void solvesuduko(int[][] board,int i,int j) {
		
		if(i == board.length) {
			display(board);
			return;
		}
		
		int ni = 0;
		int nj = 0;
		
		if(j == board[0].length - 1) {
			ni = i + 1; // if we are at last element on row then it
			nj = 0;     // will go to next row.
		}else {   
			ni = i;    // if we are in the same row and want to go 
			nj = j + 1;// till length - 1 do col + 1 and keep row same.
		}
		if(board[i][j] != 0) {//if in the place of "i" and "j" there is 
		solvesuduko(board,ni,nj);//a present of non-zero value then move forward. 
		}else {
			for(int po = 1; po <= 9; po++) {
	// option to put in a place of "0" position.			
				if(isValid(board,i,j,po) == true) {
					board[i][j] = po;
					solvesuduko(board,ni,nj);
					board[i][j] = 0;//backtrack
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		solvesuduko(arr,0,0);
		
	}
	

}
