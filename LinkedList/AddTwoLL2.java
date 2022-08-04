package LinkedList;

import java.util.*;


public class AddTwoLL2 {
	
	 public static Scanner scn = new Scanner(System.in);

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
	    	
	    	Node prev = null;
	    	Node curr = head;
	    	
	    	while(curr != null) {
	    	
	    		Node forward = curr.next;
	    		
	    		curr.next = prev;
	    		prev = curr;
	    		curr = forward;
	    	}
	    	return prev;
	    }
	    
	    public static Node addTwoNumbers(Node l1, Node l2) {
	       
	    	if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
	    	
	    	Node c1 = reverse(l1);
	    	Node c2 = reverse(l2);
	    	
	    	Node head = new Node(-1);
	    	Node itr = head;
	    	int carry = 0;
	    	
	    	while(c1 != null || c2 != null || carry != 0) {
	    		
	    		int sum = carry + (c1 != null ? c1.val : 0) + 
	    				          (c2 != null ? c2.val : 0);
	    		
	    		int lastdigit = sum % 10;
	    		        carry = sum / 10;
	    		 
	    		 itr.next = new Node(lastdigit);
	    		 itr = itr.next;
	    		 
	    		 if(c1 != null) c1 = c1.next;
	    		 if(c2 != null) c2 = c2.next;
	    	}
	    	return reverse(head.next);
	    }

	   
	    public static void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	    }

	    public static Node makeList(int n) {
	        Node dummy = new Node(-1);
	        Node prev = dummy;
	        while (n-- > 0) {
	            prev.next = new Node(scn.nextInt());
	            prev = prev.next;
	        }

	        return dummy.next;
	    }

	    public static void main(String[] args) {
	    	
	        Node head1 = makeList(scn.nextInt());
	        Node head2 = makeList(scn.nextInt());

	        Node ans = addTwoNumbers(head1, head2);
	        printList(ans);
	    }

	}