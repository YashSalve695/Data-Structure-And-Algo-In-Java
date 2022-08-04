package LinkedList;

import java.io.*;

import LinkedList.IsLLpalindrome.Node;

public class AddTwoLinkedList {


	 public static class Node {
		    int data;
		    Node next;
		  }

		  public static class LinkedList {
		    Node head;
		    Node tail;
		    int size;
		    
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
		    
		    public void display() {
			      for (Node temp = head; temp != null; temp = temp.next) {
			        System.out.print(temp.data + " ");
			      }
			      System.out.println();
			    }
             
		    /**
		     * @param one - First LinkedList.
		     * @param pv1 - place value of first LinkedList.
		     * @param two - Second LinkedList.
		     * @param pv2 - place value of second LinkedList.
		     * @param result - All the result will be store.
		     */
		    
		  public static int addListHelper(Node one,int pv1,Node two,int pv2,LinkedList result) {
			         
			  // BASE CASE
			  if(one == null && two == null) {
				  return 0;
			  }
			  int data = 0;
			  
			  // If values present in LinkedList one is more than LinkedList two.
			  if(pv1 > pv2) {
			  // pv1 will increase and pv2 will not increase.	  
				  int oldcarry = addListHelper(one.next,pv1 - 1,two,pv2,result);
				  data = one.data + oldcarry;
				  
			  // If values present in LinkedList two is more than LinkedList one.
			  } else if(pv1 < pv2) {
			  // pv2 will increase and pv1 will not increase.	 	  
				  int oldcarry = addListHelper(one,pv1,two.next,pv2 - 1,result);
				  data = two.data + oldcarry;

			 // If values present in both the LinkedLists are same.	  
			  } else {
			 // Both the values will increase simultaneously.  
				  int oldcarry = addListHelper(one.next,pv1 - 1,two.next,pv2 - 1,result);
				  data = one.data + two.data + oldcarry;
			  }
			  int newdata = data % 10;
			  int newcarry = data / 10;
			  
			  result.addFirst(newdata);
			  return newcarry;
			  
		  }

		    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {

                     LinkedList result = new LinkedList();
                     
                     int oldcarry = addListHelper(one.head,one.size,two.head,two.size,result);
                     
                     return result;
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

		    int n2 = Integer.parseInt(br.readLine());
		    LinkedList l2 = new LinkedList();
		    String[] values2 = br.readLine().split(" ");
		    for (int i = 0; i < n2; i++) {
		      int e = Integer.parseInt(values2[i]);
		      l2.addLast(e);
		    }

		    LinkedList sum = LinkedList.addTwoLists(l1, l2);

		//    int a = Integer.parseInt(br.readLine());
		  //  int b = Integer.parseInt(br.readLine());

		    l1.display();
		    l2.display();
		    sum.display();
		//    sum.addFirst(a);1 1 -1
		    
		  //  sum.addLast(b);
		 //   sum.display();
		  }
		}
