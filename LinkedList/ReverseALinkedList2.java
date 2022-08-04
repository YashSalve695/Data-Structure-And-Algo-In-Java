package LinkedList;

import java.util.*;

public class ReverseALinkedList2 {

	// POINTER ITERATIVE.
	
	 public static class Node {
	        int val = 0;
	        Node next = null;

	          Node(int val) {
	            this.val = val;
	        }
	 }

	    public static Node reverse(Node head) {
	    	
	    	if(head == null || head.next == null) {
	    		return head;
	    	}
	    	Node current = head;
	    	Node previous = null;
	    	Node forward = null;
	    	
	    	while(current != null) {
	    		
	    		forward = current.next;
	    		current.next = previous;
	    		
	    		previous = current;
	    		current = forward;
	    	}
	    	
	      
	        return previous;
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

	       Node head = reverse(dummy.next);
	        while (head != null) {
	            System.out.print(head.val + " ");
	head = head.next;
	        }
	    }
	}
     
