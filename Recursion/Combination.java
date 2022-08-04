package Recursion;

import java.util.*;

public class Combination {
	
	public static void combination(int cb,int tb,int ssf,int ts,
			                   String asf) {
		
		if(cb > tb) {
			if(ssf == ts) {
				System.out.println(asf);
			}
			return;	
		}
		combination(cb + 1,tb,ssf + 1,ts, asf + "i");
		// In this recursive call current boxes will increase and selection
		// of boxes will also increase ,and at the vacat boxes i will be placed.
		combination(cb + 1,tb,ssf,ts,asf + "-");
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int nboxes = sc.nextInt();
		int ritems = sc.nextInt();
		
		combination(1,nboxes,0,ritems,"");

	}

}
