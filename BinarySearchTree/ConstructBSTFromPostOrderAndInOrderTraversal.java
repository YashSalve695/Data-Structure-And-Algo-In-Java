package BinarySearchTree;

import java.util.*;


public class ConstructBSTFromPostOrderAndInOrderTraversal {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	    
	    private static TreeNode ConstructBST( int postorder[], int poststartindex, int postendindex,
	    		                              int inorder[], int instartindex, int inendindex) {
	    	
	    	if(instartindex > inendindex) {
	    		return null;
	    	}
	    	
	    	TreeNode rootNode = new TreeNode(postorder[postendindex]);
	    	
	    	int index = instartindex;
	    	while(inorder[index] != postorder[postendindex]) index++;
	    	int countofelement = index - instartindex;
	    	
	    	
	    	rootNode.left = ConstructBST(postorder, poststartindex, poststartindex + countofelement - 1, 
	    			                     inorder, instartindex, index - 1);
	    	
	    	rootNode.right = ConstructBST(postorder, poststartindex + countofelement, postendindex - 1, 
	    			                      inorder, index + 1, inendindex);
	    	
	    	return rootNode;
	    	
	    }
	    
	    public static TreeNode buildTree(int[] inorder, int[] postorder) {
	    	
	    	int n = inorder.length;
	    	
	    	return ConstructBST(postorder, 0, n -1 ,inorder, 0, n - 1);
	        
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
	        int[] post = new int[n];
	        for (int i = 0; i < n; i++)
	            post[i] = scn.nextInt();

	        int[] in = new int[n];
	        for (int i = 0; i < n; i++)
	            in[i] = scn.nextInt();

	        TreeNode root = buildTree(in, post);
	        display(root);
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}

// 7
// 1 3 2 5 7 6 4
// 1 2 3 4 5 6 7

