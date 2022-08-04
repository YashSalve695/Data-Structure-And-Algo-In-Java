package ArraysL2;

import java.util.*;

public class SegmentedSieve {
	
	public static void segmentSieve(int a,int b) {
		
		boolean arr[] = new boolean[b - a + 1];
		
		int rootb = (int)Math.sqrt(b);
		ArrayList<Integer> primes = sieve(rootb);
		
		for(int prime : primes) {
			int multiple = (int)Math.ceil((a * 1.0) / prime);
			 if(multiple == 1) multiple++;
			 
			 
		}
	}

	public static void main(String[] args) {
		
	}

}
