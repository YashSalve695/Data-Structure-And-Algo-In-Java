package BinaryTree;

import java.util.*;

public class HouseRobberInBinaryTree {
	
	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	    public static class housepair{
	    	
	    	int withrobbery = 0;
	    	int withoutrobbery = 0;
	    	
	    }
	    
	    private static housepair houserob(TreeNode root) {
	    	
	    	if(root == null) {
	    		return new housepair();
	    	}
	    	
	    	housepair lefthouserob = houserob(root.left);
	    	housepair righthouserob = houserob(root.right);
	    	
	    	housepair ans = new housepair();
	    	
	 ans.withrobbery = lefthouserob.withoutrobbery + root.val + righthouserob.withoutrobbery;
	 
	 ans.withoutrobbery = Math.max(lefthouserob.withrobbery, lefthouserob.withoutrobbery) +
			              Math.max(righthouserob.withrobbery, righthouserob.withoutrobbery);
	    	
	        
	    	return ans;
	    }
	    
	    public static int HouseRobber(TreeNode root) {
	        
	    	housepair res = houserob(root);
	    	
	    	return Math.max(res.withoutrobbery, res.withrobbery);
	    	
	    	
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
	        System.out.println(HouseRobber(root));
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}