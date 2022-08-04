package GenericTree;

import java.util.*;
import java.io.*;

public class NodeWithMaximumSubtreeSum {

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
		  
		  static int max_Sum_node = 0;
		  static int max_Sum = Integer.MIN_VALUE;
		  private static int Sum(Node node) {
			  
			  int sum = 0;
			  
			  for(Node child : node.children) {
				  int current_sum = Sum(child);
				  sum += current_sum;
			  }
			  sum += node.data;
			  
			  if(sum > max_Sum) {
				  max_Sum_node = node.data;
				  max_Sum = sum;
			  }
			  return sum;
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
		    int sum = Sum(root);
		    System.out.println(max_Sum_node + "@" + max_Sum);
		  }

		}

// 20
// 10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1