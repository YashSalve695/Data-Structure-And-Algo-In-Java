package LinkedList;

import java.util.*;

public class mergeTwoSortedLinkedList2 {

	  public static Scanner scn = new Scanner(System.in);

	    public static class Node {
	        int val = 0;
	        Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node mergeTwoLists(Node l1, Node l2) {
              
	    	if(l1 == null || l2 == null) {
	    		return l1 != null ? l1 : l2;
	    	}
	    	Node c1 = l1;
	    	Node c2 = l2;
	    	Node dummy = new Node(-1);
	    	Node prev = dummy;
	    	
	    	while(c1 != null && c2 != null) {
	    		
	    		if(c1.val < c2.val) {
	    			prev.next = c1;
	    			c1 = c1.next;
	    		}else {
	    			prev.next = c2;
	    			c2 = c2.next;
	    		}
	    		prev = prev.next;
	    	}
	    	prev.next = c1 != null ? c1 : c2;
	    	
	    	return dummy.next;

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
	        int m = scn.nextInt();
	        Node h2 = createList(m);


	        Node head = mergeTwoLists(h1, h2);
	        printList(head);
	    }
	}