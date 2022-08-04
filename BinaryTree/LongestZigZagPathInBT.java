
/** 1. You are given a partially written function to solve.
2. Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
    a. Choose any node in the binary tree and a direction (right or left).
    b. If the current direction is right then move to the right child of the current node 
       otherwise move to the left child.
    c. Change the direction from right to left or right to left.
    d. Repeat the second and third step until you can't move in the tree.

3. Zigzag length is defined in terms of edges. (A single node has a length of 0).
4. Return the longest ZigZag path contained in that tree. */


package BinaryTree;

import java.util.*;

public class LongestZigZagPathInBT {

	  public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	    public static class pair{
	    	
	    	/** -1 because we are doing operation on edges not on node */
	    	int forwardslope = -1;
	    	int backwardslope = -1;
	    	int maxlen = 0;
	    }
	    
	    private static pair ZigZag(TreeNode root) {
	    	
	    	if(root == null) {
	    		return new pair();
	    	}
	    	
	    	pair left = ZigZag(root.left);
	    	pair right = ZigZag(root.right);
	    	
	    	pair ans = new pair();
	    	
	    	/** This will tell the max len is in left subtree or right subtree
	    	    OR it is with node root */
	    	ans.maxlen = Math.max(Math.max(left.maxlen, right.maxlen) ,
	    			              Math.max(left.backwardslope, right.forwardslope) + 1);
	    	
	    	/** For adding its parent node also */ 
	    	ans.forwardslope = left.backwardslope + 1;
	    	ans.backwardslope = right.forwardslope + 1;
	    	
	    	return ans;
	    }
	    
	    
	    public static int longestZigZagPath(TreeNode root) {
	        
	    	pair ans = ZigZag(root);
	    	
	    	return ans.maxlen;
	    }

	    
	    public static TreeNode createTree(int[] arr, int[] IDX) {
	        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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

	        System.out.println(longestZigZagPath(root));
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}