package BinaryTree;

import java.util.*;
import java.io.*;

public class DiameterOfBinaryTree {

	 public static class Node {
		    int data;
		    Node left;
		    Node right;

		    Node(int data, Node left, Node right) {
		      this.data = data;
		      this.left = left;
		      this.right = right;
		    }
		  }

		  public static class Pair {
		    Node node;
		    int state;

		    Pair(Node node, int state) {
		      this.node = node;
		      this.state = state;
		    }
		  }

		  public static Node construct(Integer[] arr) {
		    Node root = new Node(arr[0], null, null);
		    Pair rtp = new Pair(root, 1);

		    Stack<Pair> st = new Stack<>();
		    st.push(rtp);

		    int idx = 0;
		    while (st.size() > 0) {
		      Pair top = st.peek();
		      if (top.state == 1) {
		        idx++;
		        if (arr[idx] != null) {
		          top.node.left = new Node(arr[idx], null, null);
		          Pair lp = new Pair(top.node.left, 1);
		          st.push(lp);
		        } else {
		          top.node.left = null;
		        }

		        top.state++;
		      } else if (top.state == 2) {
		        idx++;
		        if (arr[idx] != null) {
		          top.node.right = new Node(arr[idx], null, null);
		          Pair rp = new Pair(top.node.right, 1);
		          st.push(rp);
		        } else {
		          top.node.right = null;
		        }

		        top.state++;
		      } else {
		        st.pop();
		      }
		    }

		    return root;
		  }

		  public static void display(Node node) {
		    if (node == null) {
		      return;
		    }

		    String str = "";
		    str += node.left == null ? "." : node.left.data + "";
		    str += " <- " + node.data + " -> ";
		    str += node.right == null ? "." : node.right.data + "";
		    System.out.println(str);

		    display(node.left);
		    display(node.right);
		  }

		  public static int height(Node node) {
		    if (node == null) {
		      return -1;
		    }

		    int lh = height(node.left); 
		    int rh = height(node.right);

		    int th = Math.max(lh, rh) + 1;
		    return th;
		  }

		  public static int diameter(Node node) {
			  
			  if(node == null) {
				  return 0;
			  }

             int leftdiameter = diameter(node.left);
             /** maximum distance between two nodes of lhs */
			  
             int rightdiameter = diameter(node.right);
             /** maximum distance between two nodes of rhs */
             
             /** maximum distance between left deepest node 
              * and right deepest node */
              int deepest = height(node.left) + height(node.right) + 2;
              
              int totaldiameter = Math.max(deepest, Math.max(rightdiameter, leftdiameter));
              
              return totaldiameter;
		  }
		  
		  static class DiaPair{
			  
			  int height;
			  int diameter;
		  }
		  
		  public static DiaPair diameter1(Node node) {
			  
			  if(node == null) {
				  DiaPair bp = new DiaPair();
				  bp.height = -1;
				  bp.diameter = 0;
				  return bp;
			  }
			  
			  DiaPair left_pair = diameter1(node.left);
			  DiaPair right_pair = diameter1(node.right);
			  
			  DiaPair TotalDiameter = new DiaPair();
			  
			  TotalDiameter.height = Math.max(left_pair.height, right_pair.height) + 1;
			  
			  int deep = left_pair.height + right_pair.height + 2;
			  
			  TotalDiameter.diameter = Math.max(deep, Math.max(left_pair.diameter, 
					                                          right_pair.diameter));
			  
			  return TotalDiameter;
			  
			  
			  			  }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine());
		    Integer[] arr = new Integer[n];
		    String[] values = br.readLine().split(" ");
		    for (int i = 0; i < n; i++) {
		      if (values[i].equals("n") == false) {
		        arr[i] = Integer.parseInt(values[i]);
		      } else {
		        arr[i] = null;
		      }
		    }

		    Node root = construct(arr);

		   DiaPair res = diameter1(root);
		    System.out.println(res.diameter);
		  }

		}

// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

    

