package BinaryTree;

import java.util.*;

public class IsBinaryTreeABSTUsingInorderProperty {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	   static TreeNode prev = null;
	   private static boolean isValid(TreeNode root) {
		   
		   if(root == null) {
			   return true;
		   }
		   
		   if(!isValid(root.left)) return false;
		   
		   if(prev != null && prev.val > root.val) return false;
		     prev = root;
		     
		   if(!isValid(root.right)) return false;
		   
		   return true;
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
	        System.out.println(isValid(root));

	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}
