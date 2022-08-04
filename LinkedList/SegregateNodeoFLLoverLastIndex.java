package LinkedList;

import java.util.*;

public class SegregateNodeoFLLoverLastIndex {

	 public static Scanner scn = new Scanner(System.in);

	    public static class Node {
	        int val = 0;
	        Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node gettail(Node head) {
	    	
	    	if(head == null) {
	    		return head;
	    	}
	    	Node tail = head;
	    	  while(tail.next != null) {
	    		  tail = tail.next;
	    	  }
	    	  return tail;
	    }
	    
	    public static Node segregateOnLastIndex(Node head) {
             
	    	if(head == null || head.next == null) {
	    		return head;
	    	}
	    	Node tail = gettail(head);
	    	
	    	Node smaller = new Node(-1);
	    	Node larger = new Node(-1);
	    	
	    	Node ps = smaller;
	    	Node pl = larger;
	    	
	    	Node curr = head;
	    	
	    	while(curr != null) {
	    		
	    		if(curr.val <= tail.val) {
	    			ps.next = curr;
	    			ps = ps.next;
	    		}else {
	    			pl.next = curr;
	    			pl = pl.next;
	    		}
	    			curr = curr.next;
	    	}
	    	ps.next = larger.next;
	    	pl.next = null;
	    	
	    	return ps;

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
	        h1 = segregateOnLastIndex(h1);
	        printList(h1);
	    }
	}
