package GenericTree;

import java.util.*;
import java.io.*;

public class AreTressMirrorInShape {

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

 

		  public static boolean areMirror(Node n1, Node n2) {
		  
			  if(n1.children.size() != n2.children.size()) {
				  return false;
			  }
			  
			   for(int i = 0; i < n1.children.size(); i++) {
			        int pointer_at_n2 = n1.children.size() - 1 - i;
			        
			        Node c1 = n1.children.get(i);
			        Node c2 = n2.children.get(pointer_at_n2);
			        
			        if(areMirror(c1, c2) == false) {
			        	return false;
			        }
			   }
			   return true;
		  }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    int n1 = Integer.parseInt(br.readLine());
		    int[] arr1 = new int[n1];
		    String[] values1 = br.readLine().split(" ");
		    for (int i = 0; i < n1; i++) {
		      arr1[i] = Integer.parseInt(values1[i]);
		    }
		    Node root1 = construct(arr1);

		    int n2 = Integer.parseInt(br.readLine());
		    int[] arr2 = new int[n2];
		    String[] values2 = br.readLine().split(" ");
		    for (int i = 0; i < n2; i++) {
		      arr2[i] = Integer.parseInt(values2[i]);
		    }
		    Node root2 = construct(arr2);

		    boolean mirror = areMirror(root1, root2);
		    System.out.println(mirror);
		  }

		}


/** 12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
12
100 200 -1 300 500 -1 600 -1 -1 400 -1 -1 */
