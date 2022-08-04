//package BinaryTree;

import java.util.*;
import java.io.*;

public class AllNodesAtDistanceK {

	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    TreeNode(int val) {
	      this.val = val;
	    }
	  }

	  private static void k_down(TreeNode root, int k, TreeNode blockNode, ArrayList<Integer> ans) {
		  
		  if(root == null || k < 0 || root == blockNode) {
			  return;
		  }
		  
		  if(k == 0) {
			  ans.add(root.val);
			  return;
		  }
		  
		  k_down(root.left, k - 1, blockNode, ans);
		  k_down(root.right,k - 1, blockNode, ans);
	  }
	
	  public static int distanceK(TreeNode root, int target, int k, ArrayList<Integer> ans) {

		  if(root == null) {
			  return -1;
		  }
		  
		  if(root.val == target) {
			  k_down(root, k - 0, null, ans);
			  return 1;
		  }
		  
		  int left_side = distanceK(root.left, target, k, ans);
		  
		  if(left_side != -1) {
			  k_down(root, k - left_side, root.left, ans);
			  return left_side + 1;
		  }
		  
		  int right_side = distanceK(root.right, target, k, ans);
		    if(right_side != -1) {
		    	k_down(root.right, k - right_side, root, ans);
		    	return right_side + 1;
		    }
			 return -1;
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
		  
		Scanner scn = new Scanner(System.in);  
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++)
	      arr[i] = scn.nextInt();

	    int[] IDX = new int[1];
	    TreeNode root = createTree(arr, IDX);
	    int target = scn.nextInt();
	    int k = scn.nextInt();

	    
	    ArrayList<Integer> ans = new ArrayList<>();
	   int res = distanceK(root, target, k, ans);
	    if (ans.size() == 0)
	      System.out.println();
	    for (Integer ele : ans)
	      System.out.println(ele + " ");

	  }

	  public static void main(String[] args) {
	    solve();
	  }
	}


/** Always get node to root path of the given node */
