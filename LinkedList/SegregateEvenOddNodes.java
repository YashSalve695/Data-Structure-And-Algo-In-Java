package LinkedList;

import java.util.*;

public class SegregateEvenOddNodes {

	  public static class Node {
	        int val = 0;
	        Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node segregateEvenOdd(Node head) {
	       
	    	if(head == null || head.next == null) {
	    		return head;
	    	}
	    	Node dummyeven = new Node(-1);
	    	Node dummyodd = new Node(-1);
	    	
	    	Node even = dummyeven;
	    	Node odd = dummyodd;
	    	
	    	Node curr = head;
	    	
	    	while(curr != null) {
	    		if(curr.val % 2 != 0) {
	    			odd.next = curr;
	    			odd = odd.next;
	    		} else {
	    			even.next = curr;
	    			even = even.next;
	    		}
	    		curr = curr.next;
	    	}
	    	even.next = dummyodd.next;
	    	odd.next = null;
	    	
	    	return dummyeven.next;
	    	
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

	        Node head = segregateEvenOdd(dummy.next);
	        while (head != null) {
	            System.out.print(head.val + " ");
	            head = head.next;
	        }
	    }
	}
	