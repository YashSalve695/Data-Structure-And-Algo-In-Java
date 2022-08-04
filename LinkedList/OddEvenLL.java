package LinkedList;

import java.io.*;

public class OddEvenLL {

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

		    public void oddEven(){
		      
		   // To store odd even elements.
		    	LinkedList odd = new LinkedList();
		    	LinkedList even = new LinkedList();
		    	
		    	while(size() > 0) {
		    		int val = this.getFirst();// To get first element.
		    		this.removeFirst();// And remove that first element.
		    		
		    		if(val % 2 == 0) { // To the which elements are "odd" and "even".
		    			even.addLast(val);// If even then addLast in the even list.
		    		} else {
		    			odd.addLast(val);// If odd then addLast in the odd list.
		    		}
		    	}
		    // If there are odd and even elements present.
		    	if(odd.size	> 0 && even.size > 0){
		    		odd.tail.next = even.head;// Then next of tail of odd is even head. 
		    		this.head = odd.head;
		    		this.tail = even.tail;// Then tail is modified to even. 
		    		this.size = odd.size + even.size;// Then add the size of odd and even.
		    	
		    	} else if(odd.size > 0) {// To check if there are only odd elements in the list.
		    		this.head = odd.head;
		    		this.tail = odd.tail;
		    		this.size = odd.size;
		    		
		    	} else if(even.size == 0) {// To check if there are only even elements in the list.
		    		this.head = even.head;
		    		this.tail = even.tail;
		    		this.size = even.size;
		    	}
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

		//    int a = Integer.parseInt(br.readLine());
		//    int b = Integer.parseInt(br.readLine());

		//    l1.display();
		    l1.oddEven();
		    l1.display();
		//    l1.addFirst(a);
		//    l1.addLast(b);
		//    l1.display();
		  }
		}
