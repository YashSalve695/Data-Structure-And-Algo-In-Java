package BinaryTree;

import java.util.*;
import java.io.*;


public class IsBinaryTreeValid {

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

	  /** Function to know if tree is binary tree or not */ 
	  
	  static boolean isTreeValid = true;
	  private static int isBinarytreeValid(Node node) {
		  
		  if(node == null) {
			  return 0;
		  }
		  
		  int leftheight = isBinarytreeValid(node.left);
		  int rightheight = isBinarytreeValid(node.right);
		  
		  int gap_between_left_and_right = Math.abs(leftheight - rightheight);
		   
		  if(gap_between_left_and_right > 1) {
			   isTreeValid = false;
		   }
		   
		  int total_height = Math.max(leftheight, rightheight) + 1;
		  
		  return total_height;  
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
	    int res = isBinarytreeValid(root);
	    boolean is = isTreeValid;
	     System.out.println(is);
	     System.out.println(res);
	    
	   
	  }
	  
	 // 15
	 // 50 25 12 n n 37 n n 75 62 n n 87 n n

	}