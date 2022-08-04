package DynamicProgramming;

import java.util.*;

/**

1. You are given a number n and a number k in separate lines, representing the number of fences 
   and number of colors.
2. You are required to calculate and print the number of ways in which the fences could be 
   painted so that not more than two consecutive  fences have same colors.
   
8
3
3672

*/
public class PaintFence {
	
	private static int Paint_fence(int fences, int colour) {
		
		long same_colour = colour * 1;
		long diff_colour = colour * (colour - 1);
		
		long total = same_colour + diff_colour;
		
		for(int i = 3; i <= fences; i++) {
			same_colour = diff_colour * 1;
			diff_colour = total * (colour - 1);
			total = same_colour + diff_colour;
		}
		return (int)total;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int fen = sc.nextInt();
		int col = sc.nextInt();
		
		int ans = Paint_fence(fen, col);
		 System.out.println(ans);
		
	}

}
