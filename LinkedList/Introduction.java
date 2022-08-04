package LinkedList;

import java.io.*;

public class Introduction {
	
	public static class Node {
		
		int data; // Data of current node.
		Node next; // Address of next node.

	}
    public static class LinkedList {
    	
    	Node head; // Address of first node.
    	Node tail; // Address of last node.
    	int size;  // Size of the LinkedList.
    	
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
    	
    }
    
    public static void testList(LinkedList list) {
        for (Node temp = list.head; temp != null; temp = temp.next) {
          System.out.println(temp.data);
        }
        System.out.println(list.size);

        if (list.size > 0) {
          System.out.println(list.tail.data);
        } 
      }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while(str.equals("quit") == false){
          if(str.startsWith("addLast")){
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addLast(val);
          } 
          str = br.readLine();
        }

        testList(list);
      }
    }


