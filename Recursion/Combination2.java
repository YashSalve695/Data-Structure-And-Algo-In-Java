package Recursion;

import java.util.Scanner;

public class Combination2 {
	
	/**
	 * @param boxes
	 * @param ci = current item.
	 * @param ti = total item.
	 * @param lb = last box.
	 */
public static void combination2(boolean []boxes,int ci,int ti,int lb) {
		
	if(ci > ti) {
		for(int i = 0; i < boxes.length;i++) {
			if(boxes[i]) {
				System.out.print("i");
			} else {
				System.out.print("-");	
	   }
			
	}
		System.out.println();
		return;
		
	}
	for(int b = lb + 1; b < boxes.length; b++) {
		if(boxes[b] == true) {
			boxes[b] = true;
			combination2(boxes,ci + 1,ti,lb);
			boxes[b] = false;
		}
	}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int boxes = sc.nextInt();
		int items = sc.nextInt();
		
		combination2(new boolean[boxes],1,items,-1);
		}

}
