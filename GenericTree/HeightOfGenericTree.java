package GenericTree;

import java.util.*;
import java.io.*;

public class HeightOfGenericTree {

	private static class Node {
	    int data;
	    ArrayList< Node> children = new ArrayList<>();
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

	    Stack< Node> st = new Stack< >();
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

     /** height in edges not node */
	  public static int Height(Node node) {
	   
		  int height = -1;
		  
		  for(Node child : node.children) {
			  int childheight = Height(child);
			  height = Math.max(childheight, height);
		  }
		  return height + 1;
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
	    int m = Height(root);
	    System.out.println(m);
	    // display(root);
	  }

	}
