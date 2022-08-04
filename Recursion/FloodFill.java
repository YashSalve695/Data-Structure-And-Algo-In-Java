package Recursion;

import java.util.*;

public class FloodFill {
	
	public static void floodfill(int maze[][],int row,int col,String psf,boolean visited[][]) {
		
		if(row < 0 || col < 0 || row == maze.length ||   col == maze[0].length || 
		   maze[row][col] == 1 || visited[row][col] == true) {
			return;
		}
		if(row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(psf);
			return;
		}
	/** MAKE EVERY ROW & COL VISITED SO IT CANNOT VISIT THE SAME
	    ROW & COL AGAIN */
		 
		visited[row][col] = true;
		/** INSTRUCTION TO GO IN TOP DIRECTION OF MATRIX */
		floodfill(maze,row - 1 ,col,psf + "t",visited);
		
		/** INSTRUCTION TO GO IN LEFT DIRECTION OF THE MATRIX */
		floodfill(maze,row ,col - 1,psf + "l",visited);
		
		/** INSTRUCTION TO GO IN DOWN DIRECTION IN THE MATRIX */
		floodfill(maze,row + 1,col,psf + "d",visited);
		
		/** INSTRUCTION TO GO IN RIGHT DIRECTION OF THE MATRIX */
		floodfill(maze,row,col + 1,psf + "r",visited);
		visited[row][col] = false;
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); /** INPUT ROW */
		int m = sc.nextInt(); /** INPUT COL */
		int arr[][] = new int[n][m];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		boolean visited[][] = new boolean[n][m];
		floodfill(arr,0,0,"",visited);
		
		
	}

}
