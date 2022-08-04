package LinkedList;

import java.io.*;

public class MiddleofLL {

	 public static class Node {
		    int data;
		    Node next;
		  }

		  public static class LinkedList {
		    Node head;
		    Node tail;
		    int size;

		 
		    public int mid(){
		    
		    	Node slow = head;
		    	Node fast = head;
		    	
		    	while(fast.next != null && fast.next.next != null) {
//		        		odd condition         even condition 		
		    		slow = slow.next;
		    		fast = fast.next.next;
		    	}
		    	return slow.data;
		    }
		  }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    LinkedList list = new LinkedList();

		    String str = br.readLine();
		    while (str.equals("quit") == false) {
		     
		       str.startsWith("mid");
		        System.out.println(list.mid());
		      }
		      str = br.readLine();
		    }
		  }
		


