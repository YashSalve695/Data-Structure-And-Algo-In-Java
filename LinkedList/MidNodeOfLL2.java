package LinkedList;

import java.util.*;

public class MidNodeOfLL2 {

	 public static class Node {
	        int val = 0;
	         Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node midNode(Node head) {
	     
	  // If there is only one element in the LinkedList.   	
	    	if(head == null || head.next == null) {
	    		return head;
	    	}
	    
	  // Slow and fast pointer will start will be on head initially.
	    	Node slow = head;
	    	Node fast = head;
	  
	  // Will traverse till the fast of next,and fast of next of next is not null.  	
	    	while(fast.next != null && fast.next.next != null) {
	    		
	    		slow = slow.next;
	    		fast = fast.next.next;
	    		
	    	}
	  // At the end slow pointer will be at Mid Node.  	
	        return slow;
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

	        Node head = midNode(dummy.next);
	        while (head != null) {
	            System.out.print(head.val + " ");
	            head = head.next;
	        }
	    }
	}