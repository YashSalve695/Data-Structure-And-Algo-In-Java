package LinkedList;

import java.util.*;

public class Segragate01 {

	 public static Scanner scn = new Scanner(System.in);

	    public static class Node {
	        int val = 0;
	        Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node segregate01(Node head) {
       
	    	/** BASE CASE */
         if(head == null || head.next == null) {
        	 return head;
         }
         /** New List For "0" number only */
         Node zero = new Node(-1);
         /** New List For "1" number only */
         Node one = new Node(-1);
         
         /** Pointer which will be on zero list */
         Node prevzero = zero;
         /** Pointer which will be on zero list */
         Node prevone = one;
         
         /** And current pointer will be on head */
         Node curr = head;
      
         /** While there are elements in the list */
         while(curr != null) {
        	 
        /** If the value of current element is equal
         *  to "0" then the next element of prevzero
         *  will be current element. 	 */
        	 if(curr.val == 0) {
        		 prevzero.next = curr;
        		 prevzero = prevzero.next;
        	 } else {
       /** If the value of current element is equal
        *  to "1" then the next element of prevone
        *  will be current element. 	 */	 
        		 prevone.next = curr;
        		 prevone = prevone.next;
        	 }
       /** Current element will go to next element */ 	 
        	 curr = curr.next;
         }
         /** Zero of next will connect to one */
         prevzero.next = one.next; 
         /** And prevone will point to null */
         prevone.next = null;
        
         /** RETURN ZERO OF NEXT */
         return zero.next;
	    }

	    public static void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	    }

	    public static Node createList(int n) {
	        Node dummy = new Node(-1);
	        Node prev = dummy;
	        while (n-- > 0) {
	            prev.next = new Node(scn.nextInt());
	            prev = prev.next;
	        }

	        return dummy.next;
	    }

	    public static void main(String[] args) {
	        int n = scn.nextInt();
	        Node h1 = createList(n);
	        h1 = segregate01(h1);
	        printList(h1);
	    }
	}

