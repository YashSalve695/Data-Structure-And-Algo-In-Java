package LinkedList;

import java.util.*;

//import LinkedList.REmovefirstInDoublyLL.Node;



	 public class DoublyLinkedList {
		    private class Node {
		      int data = 0;
		      Node prev = null;
		      Node next = null;

		      Node(int data) {
		        this.data = data;
		      }

		    }

		    private Node head = null;
		    private Node tail = null;
		    private int size = 0;

		    public String toString() {
		      StringBuilder sb = new StringBuilder();
		      Node curr = this.head;
		      sb.append("[");
		      while (curr != null) {
		        sb.append(curr.data);
		        if (curr.next != null)
		          sb.append(", ");
		        curr = curr.next;
		      }
		      sb.append("]");

		      return sb.toString();
		    }

		    public void addFirst(int val) {
		    	Node node = new Node(val);
		    	addFirstNode(node);
		    }
                 
		    	 private void addFirstNode(Node node) {
		   	      if (this.size == 0) {
		   	        this.head = this.tail = node;
		   	      } else {
		   	        node.next = this.head;
		   	        this.head.prev = node;
		   	        this.head = node;
		   	      }
		   	      this.size++;
		   	      
		    	 
		    }

		  
	 
		  public static void main(String[] args) {
		    Scanner scn = new Scanner(System.in);
		    DoublyLinkedList dll = new DoublyLinkedList();

		    String str = scn.nextLine();
		    while (!str.equals("stop")) {
		      String[] s = str.split(" ");
		      if (s[0].equals("addFirst"))
		        dll.addFirst(Integer.parseInt(s[1]));

		      str = scn.nextLine();
		    }
		    System.out.println(dll);
		  }
		}
	 
	 /*
	  * addFirst 1
        addFirst 2
        addFirst 8
         stop
        [8, 2, 1]

	  * **/
	 