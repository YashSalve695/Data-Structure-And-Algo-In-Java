package Recursion;

import java.util.Scanner;

public class PrintMazePath {
	
	/**
	 * @param sr = source row.
	 * @param sc = source column.
	 * @param dr = destination row.
	 * @param dc = destination column.
	 * @param psf = path so far.
	 */
	
	public static void printmaze(int sr,int sc,int dr,int dc,String psf) {
	
		/** IF SOURCEROW AND SOURCECOL IS GREATER THAN DESTINATION
		    ROW AND DESTINATIONCOL THEN RETURN */
		 
		if(sr > dr || sc > dc) {
			return;
		}
		if(sr == dr && sc == dc) {
			System.out.println(psf);
			return;
		}
		/** THIS WILL INCREASE THE COL HORIZONTALLY */
		printmaze(sr,sc + 1,dr,dc,psf + "h");
		
		/** THIS WILL INCREASE THE ROW VERTICALLY */ 
		printmaze(sr + 1,sc,dr,dc,psf + "v");
	}

	public static void main(String[] args) {
		
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       
       printmaze(1,1,n,m,"");
	}

}
