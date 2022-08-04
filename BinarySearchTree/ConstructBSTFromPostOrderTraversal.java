package BinarySearchTree;

import java.util.*;

public class ConstructBSTFromPostOrderTraversal {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	    private static int index = 0;
	    private static TreeNode BSTfrompostorder(int[] postorder, int leftrange, int rightrange) {
	    	
	    	if(index < 0 || postorder[index] < leftrange || postorder[index] > rightrange) {
	    		return null;
	    	}
	    	
	    	TreeNode node = new TreeNode(postorder[index--]);
	    	
	    	node.right = BSTfrompostorder(postorder, node.val, rightrange);
	    	node.left = BSTfrompostorder(postorder, leftrange, node.val);
	    	
	    	return node;
	    	
	    }
	    public static TreeNode bstFromPostorder(int[] postorder) {
	        
	    	index = postorder.length - 1;
	    	
	    	int leftRange = -(int)1e9 - 1;
	    	int rightRange = (int)1e9 + 1;
	    	
	    	 return BSTfrompostorder(postorder, leftRange, rightRange);
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

	    public static void solve() {
	        int n = scn.nextInt();
	        int[] pre = new int[n];
	        for (int i = 0; i < n; i++)
	            pre[i] = scn.nextInt();

	        TreeNode root = bstFromPostorder(pre);
	        display(root);
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	    // 6
	    // 1 2 6 7 5 3
	}
