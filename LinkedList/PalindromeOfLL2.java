package LinkedList;

import java.util.*;

import LinkedList.MidNodeOfLL2.Node;

public class PalindromeOfLL2 {
	
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
	 
	    public static Node reverse(Node head) {
	    	
	    	if(head == null || head.next == null) {
	    		return head;
	    	}
	    	Node previous = null;
	    	Node current = head;
	    	Node forward = null;
	    	
	    	while(current != null) {
	    		
	    		forward = current.next;
	    		current.next = previous;
	    		
	    		previous = current;
	    		current = forward;
	    	}
	    	return previous;
	    }

	    public static boolean isPalindrome(Node head) {
	        
	       if(head == null || head.next == null) {
	    	   return true;
	       }
	       
	       Node mid = midNode(head);
	       Node newhead = mid.next;
	       mid.next = null;
	       
	       newhead = reverse(newhead);
	       
	       Node head_start = head;
	       Node newhead_start = newhead;
	       
	       boolean result = true;
	       while(head_start != null && newhead_start != null) {
	    	   if(head_start.val != newhead_start.val) {
	    		   result = false;
	    		   break;
	    	   }
	    	   head_start = head_start.next;
	    	   newhead_start = newhead_start.next;
	       }
	       newhead = reverse(newhead);
	       mid.next = newhead;
	       
	       return result;
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

	        System.out.println(isPalindrome(dummy.next));
	    }
	}