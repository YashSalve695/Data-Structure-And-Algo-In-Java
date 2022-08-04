package LinkedList;

public class REmovefirstInDoublyLL {

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

	    // Exceptions========================================

	    private boolean ListIsEmptyException() {
	      if (this.size == 0) {
	        System.out.print("ListIsEmpty: " );
	        return true;
	      }
	      return false;
	    }

	   

	    private void addFirstNode(Node node) {
	      if (this.size == 0)
	        this.head = this.tail = node;
	      else {
	        node.next = this.head;
	        this.head.prev = node;
	        this.head = node;
	      }
	      this.size++;
	    }  
	    
	    private Node removefirstNode() {
	    	
	    	Node node = this.head;
	    	if(this.size == 1) {
	    		this.head = this.tail = head;
	    	}else {
	    		Node forward = node.next;
	    		node.next = null;
	    		forward.prev = null;
	    		
	    		this.head = forward;
	    	}
	    	this.size--;
	    	return node;
	    }
	    public int removeFirst() {
	    	if(ListIsEmptyException()) {
	    		return -1;
	    	}
	    	return removefirstNode().data;
	    }
	    
	    private Node removelastnode() {
	    	Node node = this.tail;
	    	if(this.size == 1) {
	    		this.head = this.tail = null;
	    	} else {
	    		Node prev = node.prev;
	    		node.prev = null;
	    		prev.next = null;
	    		
	    		this.tail = prev;
	    	}
	    	this.size--;
	    	return node;
	    }
	    public int removelast() {
	    	if(ListIsEmptyException()) {
	    		return -1;
	    	}
	    	return removelastnode().data;
	    }
}