package BinarySearchTree;

import java.util.*;

public class ConstructorOfBST {

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

	  public static Node construct(int[] arr, int low, int high) {
		  
		  if(low > high) return null;
		  
		  int mid = (low + high) / 2;
		  /** It will gave us the address of parent or root node */
		  
		  int parent = arr[mid];
		  /** mid will be our parent or root node */
		  
		  Node leftchild = construct(arr, low, mid - 1);
		  /** All the small elements are on the left part of the array */ 
		   
		  Node rightchild = construct(arr, mid + 1, high);
		  /** And all the large elements are on the right part of the array */ 
		  
		  Node node = new Node(parent, leftchild, rightchild);
		  /** All the data of parent and all its left and right child will be in
		   * the node
		   */

		  return node;
	   
	  }

	  public static void display(Node node) {
		  
	    if (node == null) {
	      return;
	    }

	    String str = "";
	    str += node.left == null ? "null" : node.left.data + "";
	    str += " <- " + node.data + " -> ";
	    str += node.right == null ? "null" : node.right.data + "";
	    System.out.println(str);

	    display(node.left);
	    display(node.right);
	  }

	  public static void main(String[] args) throws Exception {
	    
		  Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int arr[] = new int[n];
		   for(int i = 0; i < n; i++) {
			   arr[i] = sc.nextInt();
		   }
		  Arrays.sort(arr);
		  Node root = construct(arr, 0, arr.length - 1);
		  display(root);
	  }
	 // 7
	 // 87 75 62 50 37 25 12

	}