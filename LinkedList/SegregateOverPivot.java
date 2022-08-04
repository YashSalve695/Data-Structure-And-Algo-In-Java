package LinkedList;

import java.util.*;

public class SegregateOverPivot {

	 public static Scanner scn = new Scanner(System.in);

	  public static class Node {
	    int val = 0;
	    Node next = null;

	    Node(int val) {
	      this.val = val;
	    }
	  }

	  public static Node segregate(Node head, int pivotIdx) {
	    return null;
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
	    int idx = scn.nextInt();
	    h1 = segregate(h1, idx);
	    printList(h1);
	  }
	}
