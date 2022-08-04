package Recursion;

import java.util.Scanner;

public class printPermutationusingBacktracking {
	
	/**
	 * @param boxes = Total boxes.
	 * @param ci = current item.
	 * @param ti = total item.
	 */
	
	public static void permutation(int[] boxes,int ci,int ti) {
		
		if(ci > ti) {
			for(int i = 0; i < boxes.length; i++) {
				System.out.print(boxes[i]);
			}
			System.out.println();
			return;
		}
		// iterate through all boxes.
		for(int i = 0; i < boxes.length; i++) {
		// if boxes are empty.	
			if(boxes[i] == 0) {
		// then place the item in the boxes.		
				boxes[i] = ci;
		// items will increase(RECURSIVE CALL).		
			permutation(boxes,ci + 1,ti);
		// make the boxes again empty,so it can check for other option.(BACKTRACK).	
			    boxes[ci] = 0;
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int boxes = sc.nextInt();
		int items = sc.nextInt();
		
		permutation(new int[boxes],1,items);

	}

}
