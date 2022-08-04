package LinkedList;

import java.util.*;

public class SubtractInLinkedList {

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
	  public static Node subtractTwoNumbers(Node l1, Node l2) {
	    
		  if(l1 == null) return l1;
		  if(l2 == null) {
			  l2.val = -l2.val;
			  return l2;
		  }
		  l1 = reverse(l1);
		  l2 = reverse(l2);
		  
		  Node head = new Node(-1);
		  Node itr = head;
		  
		  Node c1 = l1;
		  Node c2 = l2;
		  
		  int borrow = 0;
		  while(c1 != null) {
			  
			  int diff = borrow + c1.val - (c2 != null ? c2.val : 0); 
			  
			  if(diff < 0) {
				  borrow = -1;
				  diff += 10;
			  } else {
				  borrow = 0;
			  }
			  itr.next = new Node(diff);
			  itr = itr.next;
			  
			  c1 = c1.next;
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

	    Node ans = subtractTwoNumbers(head1, head2);
	    printList(ans);
	  }

	}