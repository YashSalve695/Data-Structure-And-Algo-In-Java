package BinaryTree;

import java.util.*;
import java.io.*;

public class CountSingleChildNodeInBinaryTree {

	  public static Scanner scn = new Scanner(System.in);

	  public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    TreeNode(int val) {
	      this.val = val;
	    }
	  }

	  static int count= 0;
	  private static void count_single_child(TreeNode root) {
		  
		  if(root == null || (root.left == null && root.right == null)) {
			  return;
		  }
		  
		  count_single_child(root.left);
		  count_single_child(root.right);
		  
		  if(root.left == null || root.right == null) {
			  count++;
		  }
	  }
	  
	  public static int countExactlyOneChild(TreeNode node) {
		  
		  if(node == null || (node.left == null && node.right == null)) {
			  return 0;
		  }
		  
		  int left_single_count = countExactlyOneChild(node.left);
		  int right_single_count = countExactlyOneChild(node.right);
		  
		  int ans = left_single_count + right_single_count;
		  
		  if(node.left == null || node.right == null) {
			  ans++;
		  }
		  return ans;
	  }

	  

	  public static TreeNode createTree(int[] arr, int[] IDX) {
	    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
	      IDX[0]++;
	      return null;
	    }
	    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
	    Treenode.left = createTree(arr, IDX);
	    Treenode.right = createTree(arr, IDX);

	    return Treenode;
	  }

	  public static void solve() {
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++)
	      arr[i] = scn.nextInt();

	    int[] IDX = new int[1];
	    TreeNode root = createTree(arr, IDX);

	    System.out.println(countExactlyOneChild(root));
	  }

	  public static void main(String[] args) {
	    solve();
	  }
	}