package GenericTree;

import java.util.*;
import java.io.*;

public class NodeToRootPathInGenericTree {

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

	 public static ArrayList<Integer> nodeToRootPath(Node node, int data){
	    
		 if(node.data == data) {
			 ArrayList<Integer> base = new ArrayList<>();
			 base.add(node.data);
			 return base;
		 }
		 
		 for(Node child : node.children) {
			  
			 ArrayList<Integer> path_to_node = nodeToRootPath(child, data);
			 
			 if(path_to_node.size() > 0) {
				 path_to_node.add(node.data);
				 return path_to_node;
			 }
		 }
		 return new ArrayList<>();
	 }
	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    String[] values = br.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	      arr[i] = Integer.parseInt(values[i]);
	    }

	    int data = Integer.parseInt(br.readLine());

	    Node root = construct(arr);
	    ArrayList<Integer> path = nodeToRootPath(root, data);
	    System.out.println(path);
	    // display(root);
	  }

	}

// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
// 120

