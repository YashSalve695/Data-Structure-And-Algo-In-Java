package LinkedList;

import java.util.*;

public class CopyLLwithRandomPointers {

	  public static class Node {
	        int val = 0;
	        Node next = null;
	        Node random = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node copyRandomList(Node head) {
	    	
	    	HashMap<Node,Node> map = new HashMap<>();
	    	 
	    	 Node curr = head;
	    	 Node newhead = new Node(-1);
	    	 Node prev = newhead;
	    	 
	    	 while(curr != null) {
	    		 
	    		 Node node = new Node(curr.val);
	    		 prev.next = node;
	    	     map.put(curr, node);
	    	     
	    	     prev =  prev.next;
	    	     curr = curr.next;
	    	    		 
	    	 }
	    	 newhead = newhead.next;
	    	// curr = head;
	    	 
	    	 Node c1 = head;
	    	 Node c2 = newhead;
	    	 
	    	 while(c1 != null) {
	    		 
	    		 c2.random = (c1.random != null ? map.get(c1.random) : null);
	    		 
	    		 c1 = c1.next;
	    		 c2 = c2.next;
	    	 }
	    	 return newhead;
	        
	    }

	    public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();

	        Node[] arr = new Node[n];
	        Node prev = null;

	        for (int i = 0; i < n; i++) {
	            arr[i] = new Node(0);
	            if (prev != null)
	                prev.next = arr[i];
	            prev = arr[i];
	        }

	        for (int i = 0; i < n; i++) {
	            int val = scn.nextInt();
	            int idx = scn.nextInt();

	            arr[i].val = val;
	            if(idx != -1) arr[i].random = arr[idx];
	        }

	        Node head = copyRandomList(arr[0]);
	        while (head != null) {
	            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
	            head = head.next;
	        }
	    }
	}