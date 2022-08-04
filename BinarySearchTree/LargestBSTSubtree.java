package BinarySearchTree;

import java.util.*;

import BinaryTree.IsTreeBinarySearchTree.BSTpair;
import BinaryTree.IsTreeBinarySearchTree.Node;

import java.io.*;

public class LargestBSTSubtree {

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
		  
		  
		  public static class BSTpair{
				 
				 boolean isBST;
				 int min;
				 int max;
				 Node root;
				 int size;
			 }
			  
			 private static BSTpair isBST(Node node) {
				 
				 if(node == null) {
			      BSTpair base = new BSTpair();
			      base.min = Integer.MAX_VALUE;
			      base.max = Integer.MIN_VALUE;
			      base.root = null;
			      base.size = 0;
			      base.isBST = true;
			      return base;
			      
				 }
				 
				 BSTpair leftpart = isBST(node.left);
				 BSTpair rightpart = isBST(node.right);
				 
				 BSTpair makepair = new BSTpair();
				 
				 makepair.isBST = leftpart.isBST && rightpart.isBST && 
						          (node.data >= leftpart.max && node.data <= rightpart.min);
				 
				 makepair.min = Math.min(node.data, Math.min(leftpart.min, rightpart.min));
				 makepair.max = Math.max(node.data, Math.max(leftpart.max, rightpart.max));
				 
				 if(makepair.isBST) {
					 makepair.root = node;
					 makepair.size = leftpart.size + rightpart.size + 1;
					 
				 } else if(leftpart.size > rightpart.size) {
					 
					 makepair.root = leftpart.root;
					 makepair.size = leftpart.size;
					 
				 } else {
					 
					 makepair.root = rightpart.root;
					 makepair.size = rightpart.size;
				 }
				 
				 return makepair;
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
		    
		    BSTpair bp = isBST(root);
		     System.out.println(bp.root.data + " @ " + bp.size);
		  }

		}