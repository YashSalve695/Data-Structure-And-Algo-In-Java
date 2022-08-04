package GenericTree;

import java.util.*;
import java.io.*;

public class LevelOrderZigZagTraversal {

	private static class Node {
	    int data;
	    ArrayList<Node> children = new ArrayList<>();
	  }

	  public static void display(Node node) {
		  
	    String str = node.data + " -> ";
	    for (Node child : node.children) {
	      str += child.data + ", ";
	    }
	    str += ".";
	    System.out.println(str);

	    for (Node child : node.children) {
	      display(child);
	    }
	  }

	  public static Node construct(int[] arr) {
	    Node root = null;

	    Stack<Node> st = new Stack<>();
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i] == -1) {
	        st.pop();
	      } else {
	        Node t = new Node();
	        t.data = arr[i];

	        if (st.size() > 0) {
	          st.peek().children.add(t);
	        } else {
	          root = t;
	        }

	        st.push(t);
	      }
	    }

	    return root;
	  }

	
	  public static void LevelOrderTraversalZigZag(Node node){
		  
	 	  
	    Stack<Node> mainStack = new Stack<>();
	    mainStack.push(node);
	    
	    Stack<Node> childstack = new Stack<>();
	    
	    int level = 1;
	    while(mainStack.size() > 0) {
	    	
	        node = mainStack.pop();
	        System.out.print(node.data + " ");
	        
	        if(level % 2 != 0) { // odd condition
	        	for(int i = 0; i < node.children.size(); i++) {
	        		Node child = node.children.get(i);
	        		childstack.push(child);
	        	}
	        } else {
	        	for(int i = node.children.size() - 1; i >= 0; i--) {
	        		Node child = node.children.get(i);
	        		mainStack.push(child);
	        	}
	        }
	        
	        if(mainStack.size() == 0) {
	        	
	        	mainStack = childstack;
	        	childstack = new Stack<>();
	        	level++;
	        	System.out.println();
	        }
	    }	 
   }

	  public static void main(String[] args) throws Exception {
		  
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    String[] values = br.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	      arr[i] = Integer.parseInt(values[i]);
	    }

	    Node root = construct(arr);
	    LevelOrderTraversalZigZag(root);
	  }

	}

