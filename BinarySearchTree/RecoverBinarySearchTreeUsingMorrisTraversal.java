package BinarySearchTree;

import java.util.*;

public class RecoverBinarySearchTreeUsingMorrisTraversal {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
	    
	    public static TreeNode getRightmostNode(TreeNode node, TreeNode curr) {
	    	
	    	while(node.right != null && node.right != curr) {
	    		node = node.right;
	    	}
	    	return node;
	    }

	    public static void recoverTree(TreeNode root) {
	    	
	    	TreeNode curr = root;
	    	TreeNode prev = null;
	    	TreeNode a = null;
	    	TreeNode b = null;
	    	
	    	while(curr != null) {
	    		
	    		TreeNode leftnode = curr.left;
	    		
	    		if(leftnode == null) {
	              if(prev != null && prev.val > curr.val) {
	            	  
	            	  if(a == null) {
	            		  a = prev;
	            		  b = curr;
	            	  }
	            	  prev = curr;
	            	  curr = curr.right;
	            	  
	              } else {
	            	  
	            	  TreeNode rightmost = getRightmostNode(leftnode, curr);
	            	  
	            	  if(rightmost.right == null) {
	            		  rightmost.right = curr;
	            		  curr = curr.left;
	            		  
	            	  } else {
	            		  
	            		  rightmost.right = null;
	            		  if(prev != null && prev.val > curr.val) {
	            			  if(a == null) {
	            				  a = prev;
	            				  b = curr;
	            			  }
	            			  prev = curr;
	            			  curr = curr.right;
	            		  }
	            	  }
	              }
	              
	              if(a != null) {
	            	  int temp = a.val;
	            	  a.val = b.val;
	            	  b.val = temp;
	              }
	    		}
	    	}

	    }

	   
	    public static void display(TreeNode node) {
	        if (node == null)
	            return;

	        StringBuilder sb = new StringBuilder();
	        sb.append((node.left != null ? node.left.val : "."));
	        sb.append(" -> " + node.val + " <- ");
	        sb.append((node.right != null ? node.right.val : "."));

	        System.out.println(sb.toString());

	        display(node.left);
	        display(node.right);

	    }

	    public static TreeNode createTree(int[] arr, int[] IDX) {
	        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
	            IDX[0]++;
	            return null;
	        }

	        TreeNode node = new TreeNode(arr[IDX[0]++]);
	        node.left = createTree(arr, IDX);
	        node.right = createTree(arr, IDX);

	        return node;
	    }

	    public static void solve() {
	        int n = scn.nextInt();
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++)
	            arr[i] = scn.nextInt();

	        int[] IDX = new int[1];
	        TreeNode root = createTree(arr, IDX);
	        recoverTree(root);
	        display(root);
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}
