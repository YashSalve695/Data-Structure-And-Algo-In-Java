package Heaps;

import java.util.*;

public class FindKLargestElement {

	public static void main(String[] args) {
		
	 /** INPUT */	
	  Scanner sc = new Scanner(System.in);
	  int n = sc.nextInt();
	  int arr[] = new int[n];
	   for(int i = 0; i < n; i++) {
		   arr[i] = sc.nextInt();
	   }
       int k = sc.nextInt();
       
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       
       /** i will run till end of the array */
       for(int i = 0; i < arr.length; i++) {
       
      /** Add the elements in pq still the elements 
          present in pq is equal to k */	   
    	   if(i < k) {
    		   pq.add(arr[i]);
    		   
    	   } else {
     
     /** If the elements present in the pq is equal to
         size of k then, if upcoming elements present 
         in the arr is greater than peek of the element
         present in pq then remove that element and add
         that upcoming element in pq */
    		   if(arr[i] > pq.peek()) {
    			   pq.remove();
    			   pq.add(arr[i]);
    		   }
    	   }
       }
       /** At the end, if there are elements in the pq
           print out that remaning elements in pq */
                    
       while(pq.size() > 0) {
    	   System.out.print(pq.remove() + " ");
       }
       System.out.println();
	}
	

}
