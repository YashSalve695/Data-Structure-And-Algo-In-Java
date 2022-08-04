package DynamicProgramming;

import java.util.*;

public class RussianDollEnvolpes {
	
	
	/**

1. You are given a number n, representing the number of envelopes.
2. You are given n pair of numbers, representing the width and height of each envelope.
3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
Note -> Rotation is not allowed.


11
width height

17 5
26 18
25 34
48 84
63 72
42 86
9 55
4 70
21 45
68 76
58 51

5

*/
	
	public static class Envolpe implements Comparable<Envolpe> {
		
		int width;
		int height;
		
		public Envolpe(int width, int height) {
			this.width = width;
			this.height = height;
		}
	     
		public int compareTo(Envolpe o) {
		  return this.width - o.width;
		}
		
	}
	
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		Envolpe[] env = new Envolpe[n];
		 for(int i = 0; i < n; i++) {
			 String line = sc.nextLine();
			 
			 String parts[] = line.split(" ");
			 int width = Integer.parseInt(parts[0]);
			 int height = Integer.parseInt(parts[1]);
			 
			 env[i] = new Envolpe(width, height);     
		
		 }
		  Arrays.sort(env);
		  
		  int dp[] = new int[n];
		   int overall_max = 0;
		   int max = 0;
		   
		   for(int i = 0; i < dp.length; i++) {
			   for(int j = 0; j < i; j++) {
				   
				  if(env[j].height < env[i].height && env[j].width < env[i].width) {
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
