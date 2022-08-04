package BinaryTree;

import java.util.*;

public class CamerasInBinaryTree {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	    private static int MinCamerasInBT_(TreeNode root) {
	    	
	    	if(root == null) {
	    		return 1;
	    	}
	    	
	    	int lefchild = MinCamerasInBT_(root.left);
	    	int rightchild = MinCamerasInBT_(root.right);
	    	
	    	if(lefchild == -1 || rightchild == -1) {
	    		cameras++;
	    		return 0;
	     	}
	    	
	    	if(lefchild == 0 || rightchild == 0) {
	    		return 1;
	    	}
	    	
	    	return -1;
	    }
	    
	    static int cameras = 0;
	    public static int MinCamerasInBT(TreeNode root) {
	       
	    	if(MinCamerasInBT_(root) == -1) cameras++;
	    	
	    	return cameras;
	    	
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
	        System.out.println(MinCamerasInBT(root));

	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}
