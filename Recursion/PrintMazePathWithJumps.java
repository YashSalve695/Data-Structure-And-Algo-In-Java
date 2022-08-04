package Recursion;

import java.util.Scanner;

public class PrintMazePathWithJumps {
	
	/**
	 * @param sr - source row.
	 * @param sc - source column.
	 * @param dr - destination row.
	 * @param dc - destination column.
	 * @param psf - path so far.
	 */
	
	public static void printmazepath(int sr,int sc,int dr,int dc,String psf) {
		
		if(sr == dr && sc == dc) {
			System.out.println(psf);
			return;
		}
 for(int h = 1; h <= dc - sc; h++) { // horizontal path.
	 printmazepath(sr,sc + h,dr,dc,psf + "h" + h);
 }
 for(int v = 1; v <= dr - sr; v++) { // vertical path.
	 printmazepath(sr + v,sc,dr,dc,psf + "v" + v);
 }
 for(int d = 1; d <= dr - sr && d <= dc - sc; d++) { // diagonal path.
	 printmazepath(sr + d,sc + d,dr,dc,psf + "d" + d);
 }
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		printmazepath(1,1,n,m,"");
	}

}
