package LinkedList;

import java.io.*;

public class IntersectionOfTwoLinkedlist {

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
          
	    private Node getNodeAt(int idx) {
		      Node temp = head;
		      for (int i = 0; i < idx; i++) {
		        temp = temp.next;
		      }
		      return temp;
		    }
	   

	    public static int findIntersection(LinkedList one, LinkedList two){
	    	
	    	Node t1 = one.head;
	    	Node t2 = two.head;
	    	
	    	int delta = Math.abs(one.size - two.size);
	    	
	    	if(one.size > two.size) {
	    		for(int i = 0; i < delta; i++) {
	    			t1 = t1.next;
	    		}
	    	} else {
	    		for(int i = 0; i < delta; i++) {
	    			t2 = t2.next;
	    		}
	    	}
	         while(t1 != t2) {
	        	 t1 = t1.next;
	        	 t2 = t2.next;
	         }
	         return t1.data;
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
	      int d = Integer.parseInt(values2[i]);
	      l2.addLast(d);
	    }

	    int li = Integer.parseInt(br.readLine());
	    int di = Integer.parseInt(br.readLine());
	    if(li == 1){
	      Node n = l1.getNodeAt(di);
	      l2.tail.next = n;
	      l2.tail = l1.tail;
	      l2.size += l1.size - di;
	    } else {
	      Node n = l2.getNodeAt(di);
	      l1.tail.next = n;
	      l1.tail = l2.tail;
	      l1.size += l2.size - di;
	    }

	    int inter = LinkedList.findIntersection(l1, l2);
	    System.out.println(inter);
	  }
	}
