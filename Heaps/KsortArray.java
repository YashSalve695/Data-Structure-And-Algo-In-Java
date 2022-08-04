package Heaps;

import java.util.*;

public class KsortArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int arr[] = new int[n];
         for(int i = 0; i < n; i++) {
        	 arr[i] = sc.nextInt();
         }
         int k = sc.nextInt();
         
         PriorityQueue<Integer> pq = new PriorityQueue<>();
         
         /** Add the elements in pq till the equal
             to the size of k */ 
         for(int i = 0; i <= k; i++) {
        	 pq.add(arr[i]);
         }
         
         /** run the loop after k element till the
             end of the arr ,And remove the element
             which is lowest element present in the 
             pq and add the next element in the arr */
         for(int i = k + 1 ; i < arr.length; i++) {
        	 System.out.println(pq.remove());
        	 pq.add(arr[i]);
         }
         /** After that if element present in pq 
             print that elements */
         while(pq.size() > 0) {
        	 System.out.print(pq.remove() + " ");
         }
             System.out.println();
	}
}
