package LinkedList;

import java.util.*;

public class Segregate012 {

	 public static Scanner scn = new Scanner(System.in);

	    public static class Node {
	        int val = 0;
	        Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node segregate012(Node head) {
            
	    	if(head == null || head.next == null) {
	    		return head;
	    	}
	    	
	    	Node zero = new Node(-1);
	    	Node prevzero = zero;
	    	
	    	Node one = new Node(-1);
	    	Node prevone = one;
	    	
	    	Node two = new Node(-1);
	    	Node prevtwo = two;
	    	
	    	Node curr = head;
	    	
	    	while(curr != null) {
	    		
	    		if(curr.val == 0) {
	    			prevzero.next = curr;
	    			prevzero = prevzero.next;
	    			
	    		}else if(curr.val == 1) {
	    			prevone.next = curr;
	    			prevone = prevone.next;
	    			
	    		} else {
	    			prevtwo.next = curr;
	    			prevtwo = prevtwo.next;
	    		}
	    		curr = curr.next;
	    	}
	    	prevone.next = two.next;
	    	prevzero.next = one.next;
	    	prevtwo.next = null;
	    	
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
	        h1 = segregate012(h1);
	        printList(h1);
	    }
	}
