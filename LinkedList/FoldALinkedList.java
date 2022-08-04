package LinkedList;

import java.io.*;

public class FoldALinkedList {

	 public static class Node {
		    int data;
		    Node next;
		  }

		  public static class LinkedList {
	
		    Node head;
		    Node tail;
		    int size;
		    

	    	void addLast(int val) {
	    		
	    		Node temp = new Node(); // New node is created.
				temp.data  = val; // Data is head.
				temp.next = null; // Address of next element is null.
	    		
	    		if(size == 0) {	
	    			head = tail = temp;
	    		} else {	
	    			tail.next = temp;
	    			tail = temp;		
	    		}
	    		size++;
	    	}

		    public void display() { // DISPLAY FUNCTION.
			      for (Node temp = head; temp != null; temp = temp.next) {
			        System.out.print(temp.data + " ");
			      }
			      System.out.println();
		    }
		        
		    
		 // INPUT: 1 -> 2 -> 3 -> 4 -> 5
	    // OUTPUT: 1 -> 5 -> 2 -> 4 -> 3
		    
		    
		    private void foldHelper(Node right,int floor) {
		    	 
		    	if(right == null) {
		    		return;
		    	}
		    	
		    	foldHelper(right.next,floor + 1);
		    	
		    		  if(floor > size/2) {
		    		 Node temp = foldleft.next; // i.e 2.
		    		 foldleft.next = right; // i.e 1 -> 5.
		    		 right.next = temp;// 5 -> 2.
		    		 foldleft = temp; // left will increase i.e 2.
		    		 
		    	 }else if(floor == size/2) {
				    
		    		 tail = right;
		    		 tail.next = null;
				    }
		    } 
		    
		    Node foldleft;// Global variable(Created in Heap Memory).
		    public void fold() {
		      
		    	foldleft = head;// Initially head is passed in foldleft.
		    	foldHelper(head,0);
		    }
		  }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    int n1 = Integer.parseInt(br.readLine());
		    LinkedList l1 = new LinkedList();
		    String[] values1 = br.readLine().split(" ");
		    for (int i = 0; i < n1; i++) {
		      int d = Integer.parseInt(values1[i]);
		      l1.addLast(d);
		    }

		 //   int a = Integer.parseInt(br.readLine());
		//    int b = Integer.parseInt(br.readLine());

		 //   l1.display();
		    l1.fold();
		    l1.display();
		 //   l1.addFirst(a);
		//    l1.addLast(b);
		//    l1.display();
		  }
		}