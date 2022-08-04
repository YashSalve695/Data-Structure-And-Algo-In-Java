package HashMaps;

import java.util.*;
import java.io.*;

public class LRUCache {
	
	private static void addNode(Node node) {
		
		Node neighbour = head.next;
		node.next = neighbour;
		node.prev = head;
		
		neighbour.prev = node;
		head.next = node;
	}
	
	private static void removeNode(Node node) {
		
		Node prevNeighbour = node.prev;
		Node nextNeighbour = node.next;
		
		prevNeighbour.next = nextNeighbour;
		nextNeighbour.prev = prevNeighbour;
		
		node.prev = node.next = null;
	    
	}

	private static void movetofront(Node node) {
		
		removeNode(node);
		addNode(node);
	}
	
	static class Node {
		int key, value;
		Node prev, next;
	}
	
	 static HashMap<Integer, Node> cache;
	 static int cap;
	 static Node head, tail;
	
	public static class LRU {
	 LRU(int capacity) {
      
		 cache = new HashMap<>();
		 cap = capacity;
		 head = new Node();
		 tail = new Node();
		 
		 head.next = tail;
		 tail.next = head;
	    }

	    public int get(int key) {
  
	    	Node node = cache.get(key);
	    	
	    	if(node == null) {
	    		return -1;
	    		
	    	} else {
	    		
	    		int val = node.value;
	    		movetofront(node);
	    		return val;
	    	}	
	    }

	    public static void put(int key, int value) {
           
	    	Node node = cache.get(key);
	    	
	    	if(node == null) {
	    		Node newNode = new Node();
	    		newNode.key = key;
	    		newNode.value = value;
	    		
	    		if(cache.size() == cap) {
	    			Node LRU_Node = tail.prev;
	    			cache.remove(LRU_Node.key);
	    			removeNode(LRU_Node);
	    		}
	    		
	    		cache.put(key, newNode);
	    		addNode(newNode);
	    		
	    	} else {
	    		
	    		node.value = value;
	    		movetofront(node);
	    	}
	    }
	   }
	
      public static void main(String[] args) throws Exception {
		  
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();
	    LRU obj =  new LRU(Integer.parseInt(str.split(" ")[1]));

	    while (true) {
	      str = br.readLine();
	      String inp[] = str.split(" ");
	      if (inp.length == 1) {
	        break;
	      } else if (inp.length == 2) {
	        System.out.println(obj.get(Integer.parseInt(inp[1])));
	      } else if (inp.length == 3) {
	        LRU.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
	      }
	    }
	    System.out.println();
	  }
	}
	  
	
