package LinkedList;

import java.io.*;

public class ReverseALinkedListByk {

	 public static class Node {
		    int data;
		    Node next;
		  }

		  public static class LinkedList {
		    Node head;
		    Node tail;
		    int size;

		    void addLast(int val) {
		      Node temp = new Node();
		      temp.data = val;
		      temp.next = null;

		      if (size == 0) {
		        head = tail = temp;
		      } else {
		        tail.next = temp;
		        tail = temp;
		      }

		      size++;
		    }

		    public int size() {
		      return size;
		    }

		    public void display() {
		      for (Node temp = head; temp != null; temp = temp.next) {
		        System.out.print(temp.data + " ");
		      }
		      System.out.println();
		    }

		    public void removeFirst() {
		      if (size == 0) {
		        System.out.println("List is empty");
		      } else if (size == 1) {
		        head = tail = null;
		        size = 0;
		      } else {
		        head = head.next;
		        size--;
		      }
		    }

		    public int getFirst() {
		      if (size == 0) {
		        System.out.println("List is empty");
		        return -1;
		      } else {
		        return head.data;
		      }
		    }

		  

		   
		    

		    public void addFirst(int val) {
		      Node temp = new Node();
		      temp.data = val;
		      temp.next = head;
		      head = temp;

		      if (size == 0) {
		        tail = temp;
		      }

		      size++;
		    }

		   
		   
		    public void kReverse(int k) {
		      
		    	LinkedList previous = null;
		    	
		    	while(this.size > 0) {// To the operation till there are elements.
		    		LinkedList current = new LinkedList();
		    		
		    if(this.size >= k) {// "k" is from which we have to reverse.
		    	for(int i = 0; i < k; i++) {
		        	int val = this.getFirst();// get first element.
		           	this.removeFirst(); //And remove that first element.
		    		current.addFirst(val);// And add that first element in current List.
		    	}
		    } else {
		   		//For size that is less than k. 
		    	int os = this.size();
		    	 for(int i = 0; i < os; i++) {
		    		 int val = this.getFirst();
		    		 this.removeFirst();
		    		   current.addLast(val);// Add that element on last.
		    			 }
		    		}	 
		    		
		    		if(previous == null) {// If there are no elements.
		    			previous = current; // Then make previous == to previous size.
		    		} else {
		    			previous.tail.next = current.head;// Point previous tail.next to current head.
		    			previous.tail = current.tail;// And tail will now be modified.
		    			previous.size += current.size;// Make previous plus current size.
		    		}
		    				   
		    	}
		    			this.head = previous.head;
		    			this.tail = previous.tail;
		    			this.size = previous.size;
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

		    int k = Integer.parseInt(br.readLine());
		//    int a = Integer.parseInt(br.readLine());
		//    int b = Integer.parseInt(br.readLine());

		 //   l1.display();
		    l1.kReverse(k);
		    l1.display();
		//    l1.addFirst(a);
		//    l1.addLast(b);
		//    l1.display();
		  }
		}


