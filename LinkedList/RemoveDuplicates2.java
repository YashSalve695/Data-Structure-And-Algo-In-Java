package LinkedList;
import java.util.*;

public class RemoveDuplicates2 {

	 public static Scanner scn = new Scanner(System.in);

	    public static class Node {
	        int val = 0;
	        Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node removeDuplicates(Node head) {
	       
	    	if(head == null || head.next == null) {
	    		return head;
	    	}
	    	Node dummy = new Node(-1);
	    	Node itr = dummy;
	    	Node curr = head;
	    	
	    	while(curr != null && itr.val == curr.val) curr = curr.next;
	    	
	    	itr.next = curr;
	    	itr = itr.next;
	    	
	    	if(curr != null) curr = curr.next;
	    	
	    	return dummy.next;
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
	        Node head = makeList(scn.nextInt());

	        Node ans = removeDuplicates(head);
	        printList(ans);
	    }

	}