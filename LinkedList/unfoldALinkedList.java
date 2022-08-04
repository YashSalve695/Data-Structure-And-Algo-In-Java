package LinkedList;

import java.util.*;

public class unfoldALinkedList {
	
	public static Node reverse(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		Node prev = null;
		Node curr = head;
		Node forward = null;
		
		while(curr != null) {
			
			forward = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = forward;
		}
		return prev;
	}
 
	 public static class Node {
	        int val = 0;
	        	Node next = null;

	        	Node(int val) {
	            this.val = val;
	        }
	    }

	    public static void unfold(Node head) {
	    	
	    	if(head == null || head.next == null) {
	    		  return;
	    	}
	          // It will be on head.	
              Node firsthead = head;
              // "FirstPrev" will start from "FirstHead".
              Node firstprev = firsthead;
              // "SecondHead" will be on head.next.
              Node secondhead = head.next;
              // "SecondPrev" will start from "SecondHead".
              Node secondprev = secondhead;
              
       // Loop will run till "SecondPrev" is not equal to null.
       // "second.next" is not equal to null.       
              while(secondprev != null && secondprev.next != null) {
            	  
            // Forward will always be on "SecondPrev.next"	  
            	  Node forward = secondprev.next;
            	
            /** FORWARD MOVES **/
           // "FirstPrev" of next will be on forward. 	  
            	  firstprev.next = forward;
           //  "SecondPrev" of next will be on forward.next.	  
            	  secondprev.next = forward.next;
            	
           // "FirstPrev" and "SecondPrev" will move forward. 	  
            	  firstprev = firstprev.next;
            	  secondprev = secondprev.next;
              }
          // Then make "FristPrev" null.   
              firstprev.next = null;
          // And reverse the SecondHead.    
              secondhead = reverse(secondhead);
          // And make "FirstPrev" next to SecondHead.    
              firstprev.next = secondhead;
	    }

	    static void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        	Node dummy = new Node(-1);
	       	    Node prev = dummy;
	        while (n-- > 0) {
	            prev.next = new Node(scn.nextInt());
	            prev = prev.next;
	        }

	        Node head = dummy.next;
	        unfold(head);
	        printList(head);
	    }
	}
