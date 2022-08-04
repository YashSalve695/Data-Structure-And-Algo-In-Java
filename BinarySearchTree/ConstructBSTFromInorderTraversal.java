package BinarySearchTree;

import java.util.*;

public class ConstructBSTFromInorderTraversal {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	    private static TreeNode constructfromInorder(int inOrder[], int startindex, int endindex) {
	    	
	    	if(startindex > endindex) {
	    		return null;
	    	}
	    	
	    	int rootNode = (startindex + endindex) / 2;
	    	
	    	TreeNode node = new TreeNode(inOrder[rootNode]);
	    	
	    	node.left = constructfromInorder(inOrder, startindex, rootNode - 1);
	    	node.right = constructfromInorder(inOrder, rootNode + 1, endindex);
	    	
	    	return node;
	    	
	    }
	    
	    public static TreeNode constructFromInOrder(int[] inOrder) {
	       
	    	int n = inOrder.length;
	    	
	    	return constructfromInorder(inOrder, 0, n - 1);
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
	        int[] in = new int[n];
	        for (int i = 0; i < n; i++)
	            in[i] = scn.nextInt();

	        TreeNode root = constructFromInOrder(in);
	        display(root);
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	    
	    // 7
	    // 1 2 3 4 5 6 7
	}