package LinkedList;

import java.util.*;

public class IntersectionNodeInTwoLLFloydCycle {

	 public static Scanner scn = new Scanner(System.in);

	    public static class Node {
	        int val = 0;
	        Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node startingNodeofCycle(Node head) {
	    	
	    	if(head == null || head.next == null) {
	    		return head;
	    	}
	    	Node slow = head;  
	    	Node fast = head;
	    	
	    	while(fast != null && fast.next != null) {
	    		
	    		slow = slow.next;
	    		fast = fast.next.next;
	    		
	    		if(slow == fast) break;
	    	}
	    	if(slow != fast) return null;
	    	
	    	slow = head;
	    	fast = fast;
	    	
	    	while(slow != fast) {
	    		
	    		slow = slow.next;
	    		fast = fast.next;
	    	}
	    	return slow;
	    }
	    public static Node IntersectionNodeInTwoLL(Node headA, Node headB) {
	        
	    	if(headA == null || headB == null) {
	    		return null;
	    	}
	    	Node tail = headA;
	    	
	    	while(tail.next != null) tail = tail.next;
	    	
	    	tail.next = headB;
	    	
	    	Node ans = startingNodeofCycle(headA);
	    	
	    	tail.next = null;
	    	return ans;	
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

	        int idx = scn.nextInt();

	        Node head2 = makeList(scn.nextInt());

	        if (idx >= 0) {
	            Node curr = head1;
	            while (idx-- > 0)
	                curr = curr.next;

	            Node prev = head2;
	            while (prev.next != null)
	                prev = prev.next;

	            prev.next = curr;
	        }

	        Node ans = IntersectionNodeInTwoLL(head1, head2);
	        System.out.println(ans != null ? ans.val : -1);
	    }
	}