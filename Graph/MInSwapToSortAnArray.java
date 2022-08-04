package Graph;

import java.util.*;
import java.io.*;

public class MInSwapToSortAnArray {
	
	/** 
	 
	 Given an array of n distinct elements, 
	 find the minimum number of swaps required to sort the array.
	 
	 5
     10 19 6 3 5
     
     2
	 
	 */

	 public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine());
		    int[] arr = new int[n];

		    String[] st = br.readLine().split(" ");
		    for (int i = 0; i < n; i++) {
		      arr[i] = Integer.parseInt(st[i]);
		    }

		    System.out.println(minSwaps(arr));
		  }

		  public static int minSwaps(int[] arr1) {
			  
			  int n = arr1.length; /** length of arr1 */
			  
              Pair arr[] = new Pair[n];
               for(int i = 0; i < n; i++) {
            	   arr[i] = new Pair(arr1[i], i);
            /** Make pair arr of the val and index */	   
               }
               Arrays.sort(arr);
             /** Sort the pair arr */  
               
               int ans = 0;
               
               boolean visited[] = new boolean[n];
             /** To mark visited so it will not visit again */  
               
               for(int i = 0; i < n; i++) {
            	   if(visited[i] == true || arr[i].idx == i) {
            		   continue;
            		   /**  */
            	   }
            	   
            	   int cycle_len = 0;
            	   int j = i;
            	   
            	   while(visited[j] == false) {
            		   visited[j] = true;
            		   cycle_len++;
            		   j = arr[j].idx;
            	   }
            	   ans += (cycle_len - 1);
               }
               return ans;
		  }

		  private static class Pair implements Comparable<Pair> {
		    int val;
		    int idx;

		    Pair(int val, int idx) {
		      this.val = val;
		      this.idx = idx;
		    }

		  
		    public int compareTo(Pair o) {
		      return this.val - o.val;
		    }
		  }
		}

