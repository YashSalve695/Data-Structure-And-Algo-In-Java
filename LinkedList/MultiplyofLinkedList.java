package LinkedList;

import java.util.*;

public class MultiplyofLinkedList {

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
	    	Node curr = head;
	    	Node prev = null;
	    	Node forward = null;
	    	
	    	while(curr != null) {
	    		
	    		 forward = curr.next;
	    		 curr.next = prev;
	    		
	    		prev = curr;
	    		curr = forward;
	    	
	    	}
	    	return prev;
	    }
	    
	    public static Node multiplyLLwithdigit(Node head,int digit) {
	    	
	    	Node dummy = new Node(-1);
	    	Node res = dummy;
	    	Node curr = head;
	    	
	    	int carry = 0;
	    	 while(curr != null || carry != 0) {
	    		 
	    		 int sum = carry + (curr != null ? curr.val : 0) * digit;
	    		 
	    		 int dig = sum % 10;
	    		 carry = sum / 10;
	    		
	    		 res.next = new Node(dig);
	    		 if(curr != null) curr = curr.next;
	    		 res = res.next; 		 
	    	 }
	    	 return dummy.next;
	    }
	
	    public static void addtwoLL(Node head,Node ansitr) {
	    	
	    	
	    	Node c1 = head;
	    	Node c2 = ansitr;
	    	int carry = 0;
	    	
	    	while(c1 != null || carry != 0) {
	    		
	         int sum = carry + (c1 != null ? c1.val : 0) + 
			                   (c2 != null ? c2.val : 0);
	         
	         int digit = sum % 10;
	             carry = sum / 10;
	             
	             if(c2.next != null) c2.next.val = digit;
	             else c2.next = new Node(digit);
	             
	             if(c1 != null) c1 = c1.next;
	              c2 = c2.next;
	    	}
	    }

	    
	    public static Node multiplyTwoLL(Node l1, Node l2) {
             
	    	if(l1 == null) return l1 != null ? l1 : l2;
            
	    	l1 = reverse(l1);
	    	l2 = reverse(l2);
	    	
	    	Node dummy = new Node(-1);
	    	Node l2_itr = l2;
	    	Node ansitr = dummy;
	    	
	    	while(l2_itr != null) {
	    		
	    		Node prod = multiplyLLwithdigit(l1,l2_itr.val);
	    		l2_itr = l2_itr.next;
	    		
	    		addtwoLL(prod,ansitr);
	    		ansitr = ansitr.next;
	    	}
	    	return reverse(dummy.next);
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

	        Node ans = multiplyTwoLL(head1, head2);
	        printList(ans);
	    }

	}