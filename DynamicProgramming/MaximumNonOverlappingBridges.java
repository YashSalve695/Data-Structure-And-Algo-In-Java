package DynamicProgramming;

import java.util.*;

/**

1. You are given a number n, representing the number of bridges on a river.
2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
3. You are required to print the count of maximum number of non-overlapping bridges.


10
10 20
2 7
8 15
17 3
21 40
50 4
41 57
60 80
80 90
1 30

7

*/

public class MaximumNonOverlappingBridges {
	
	public static class Bridge implements Comparable<Bridge> {
		
		int north;
		int south;
		
		Bridge(int north, int south){
			this.north = north;
			this.south = south;
		}
		
		public int compareTo(Bridge o) {
		
			/** Sort arr in north */
			if(this.north != o.north) {
				return this.north - o.north;
			} else { /** if there are same elements in north, sort on south values */
				return this.south - o.south;
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		Bridge[] brg = new Bridge[n];
		   for(int i = 0; i < n; i++) {
			   String line = sc.nextLine();
			   
			   String parts[] = line.split(" ");
			   int nrt = Integer.parseInt(parts[0]);
			   int sth = Integer.parseInt(parts[1]);
			   brg[i] = new Bridge(nrt, sth);
		   }
		   
		   Arrays.sort(brg);
		   
		   int dp[] = new int[n];
		   
		   int overall_max = 0;
		   int max = 0;
		   
		   /** Take out LIS on south bank and not on 
		       north bank because north is always sorted */
		   
		   
		   /** This would work because north bank is already sorted,
		       and we are finding LIS on south bank so we will find most bridges
		       that does not overlap */
		   for(int i = 0; i < dp.length; i++) {
			   for(int j = 0; j < i; j++) {
				   
				   if(brg[j].south <= brg[i].south) {
					   if(dp[j] > max) {
						   max = dp[j];
					   }
				   }
			   }
			   dp[i] = max + 1;
			   
			   if(dp[i] > overall_max) {
				   overall_max = dp[i];
			   }
		   }
      System.out.println(overall_max);
	}

}
