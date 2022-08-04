package LinkedList;

import java.io.*;

public class kthElementInLL {
	
	 public static class Node {
		    int data;
		    Node next;
		  }

		  public static class LinkedList {
		    Node head;
		    Node tail;
		    int size;
		 
		    public int kthFromLast(int k){
		    	
		    	Node slow = head; // Slow pointer will be on head.
		    	Node fast = head; // Fast pointer will also be on head initially.
		    	
		    	for(int i = 0; i < k; i++) { // We have to move fast pointer till k times as given.
		    		fast = fast.next; 
		    	}
		    	while(fast != tail) { // Till fast of next is not at tail.
		    		
		    		slow = slow.next;
		    		fast = fast.next;
		    	}
		    	return slow.data;
		     
		    }
		  }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    LinkedList list = new LinkedList();

		    String str = br.readLine();
		    while (str.equals("quit") == false) {
		     
		       str.startsWith("kthFromEnd");
		        int idx = Integer.parseInt(str.split(" ")[1]);
		        System.out.println(list.kthFromLast(idx));
		      }
		      str = br.readLine();
		    }
		  }
		
	

