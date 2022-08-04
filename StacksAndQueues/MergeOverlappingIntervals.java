package StacksAndQueues;

import java.util.*;
import java.io.*;

public class MergeOverlappingIntervals {

	public static class Pair implements Comparable<Pair>{
		
		int startime;
		int endtime;
		
		Pair(int startime,int endtime){
			this.startime = startime;
			this.endtime = endtime;
		}
		
		public int compareTo(Pair other) {
			 
			if(this.startime != other.startime) {
				return this.startime - other.startime;
			} else {
				return this.endtime - other.endtime;
			}	
		}
		public static void mergeoverlappingIntervals(int[][] arr) {
			
			Pair[] pairs = new Pair[arr.length];
			  for(int i = 0; i < arr.length; i++) {
				  pairs[i] = new Pair(arr[i][0],arr[i][1]);
			  }
			  Arrays.sort(pairs);
			  
			  Stack<Pair> st = new Stack<>();
			   for(int i = 0; i < pairs.length; i++) {
				   
				   if(i == 0) {
					   st.push(pairs[i]);
					   
				   } else {
					   Pair top = st.peek();
					   if(pairs[i].startime > top.endtime) {
						   st.push(pairs[i]);
						   
					   } else {
						   top.endtime = Math.max(top.endtime,pairs[i].endtime);
					   }
				   }
			   }
			   Stack<Pair> res = new Stack<>();
			     while(st.size() > 0) {
			    	 res.push(st.pop());
			     }
			     while(res.size() > 0) {
			    	 Pair p = res.pop();
			    	 System.out.println(p.startime + " " + p.endtime);
			     }
		}
	}
	
	public static void main(String[] args) {
	     
		   // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        
        }
        mergeoverlappingIntervals(arr);
   
	}
}


