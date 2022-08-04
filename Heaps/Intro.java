package Heaps;

import java.util.*;

public class Intro {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int arr[] = new int[n];
          for(int i = 0; i < n; i++) {
        	  arr[i] = sc.nextInt();
          }
          PriorityQueue<Integer> pq = new PriorityQueue<>();
		       
          for(int val : arr) {
			pq.add(val);        
		}
          while(pq.size() > 0) {
        	  System.out.print(pq.peek() + " ");
        	  pq.remove();
          }
          System.out.println();
	}

}
