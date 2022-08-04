package LinkedList;
import java.util.*;

public class RemoveAllDuplicates {

	  public static Scanner scn = new Scanner(System.in);

	    public static class Node {
	        int val = 0;
	        Node next = null;

	        Node(int val) {
	            this.val = val;
	        }
	    }

	    private static Node removeDuplicates(Node head) {

           if(head == null || head.next == null) {
        	   return head;
           }
           Node dummy = new Node(-1);
           Node itr = dummy;
           itr.next = head;
           
           Node curr = head.next;
          
           while(curr != null) {
        	   
        	   boolean flag = false;
        	   while(curr != null && itr.next.val == curr.val) {
        		   flag = true;
        		   curr = curr.next;
        	   }
        	   if(flag) itr.next = curr;
        	   else itr = itr.next;
        	   
        	   if(curr != null) curr = curr.next;
           }
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