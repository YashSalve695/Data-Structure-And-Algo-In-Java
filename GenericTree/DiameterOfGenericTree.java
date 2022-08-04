package GenericTree;

import java.util.*;
import java.io.*;

public class DiameterOfGenericTree {

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

		  static int diameter = 0;
		  private static int diameter(Node node) {
			  
			/** -1 because we are calculating height on edges not on node */  
			  int deepest_child_height = -1;
			  int second_deep_child_height = -1;
			  
			  for(Node child : node.children) {
				  int child_height = diameter(child);
				  
				  if(child_height > deepest_child_height) {
					  
					  second_deep_child_height = deepest_child_height;
					  deepest_child_height = child_height;
					  
				  } else if(child_height > second_deep_child_height) {
					  
					  second_deep_child_height = child_height;
				  }
			  }
			  
			  int height = deepest_child_height + second_deep_child_height + 2;
			  
			  if(height > diameter) {
				  diameter = height;
			  }
			  deepest_child_height += 1;
			  
			  return deepest_child_height;
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
		    int height = diameter(root);
		     System.out.println(diameter);
		  }

		}

// 20
// 10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1

