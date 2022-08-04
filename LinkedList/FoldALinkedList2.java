package LinkedList;

import java.util.*;

public class FoldALinkedList2 {
	
	 public static class Node {
	        int val = 0;
	        Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }
        
	     public static Node midNode(Node head) {
	    	 
             if(head == null || head.next == null) {
            	 return head;
             }
             Node slow = head;
             Node fast = head;
             
             while(fast.next != null && fast.next.next != null) {
            	 
            	 slow = slow.next;
            	 fast = fast.next.next;
             }
             return slow;
	     }
	     
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
	     
	    public static void fold(Node head) {
           
	    	if(head == null || head.next == null) {
	    		return;
	    	}
	    	Node mid = midNode(head); // FUNCTION CALL.
	    	Node newhead = mid.next;
	    	mid.next = null;
	    	
	        newhead = reverse(newhead); // FUNCTION CALL.
	    	
	    	Node c1 = head;
	    	Node c2 = newhead;
	    	Node f1 = null;
	    	Node f2 = null;
	    	
	    	while(c2 != null) {
	    		
	    		f1 = c1.next;
	    		f2 = c2.next;
	    		
	    		c1.next = c2;
	    		c2.next = f1;
	    		
	    		c1 = f1;
	    		c2 = f2;
	    	}
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
	        fold(head);
	        printList(head);
	    }
	}
