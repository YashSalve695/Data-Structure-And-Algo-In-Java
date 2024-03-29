package BinaryTree;

import java.util.*;

public class InOrderMorrisTraversal {

	public static Scanner scn = new Scanner(System.in);

	  public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    TreeNode(int val) {
	      this.val = val;
	    }
	  }

	  private static TreeNode getRightMost(TreeNode leftnode, TreeNode curr) {
		  
		  while(leftnode.right != null && leftnode.right != curr) {
			  
			  leftnode = leftnode.right;
		  }
		  return leftnode;
	  }
	  
	  public static ArrayList<Integer> morrisInTraversal(TreeNode node) {
	   
		  ArrayList<Integer> ans = new ArrayList<>();
		  
		  TreeNode curr = node;
		  
		  while(curr != null) {
			  
			  TreeNode leftnode = curr.left;
			  if(leftnode == null) {
				  ans.add(curr.val);
				  curr = curr.right;
				  
			  } else {
				  
				  TreeNode rightMostNode = getRightMost(curr.left, curr);
				  
				  if(rightMostNode.right == null) {
					  rightMostNode.right = curr;
					  curr = curr.left;
					  
				  } else {
					  
					  rightMostNode.right = null;
					  ans.add(curr.val);
					  curr = curr.right;
				  }
			  }
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

	    ArrayList<Integer> ans = morrisInTraversal(root);
	    for (Integer i : ans)
	      System.out.print(i + " ");

	  }

	  public static void main(String[] args) {
	    solve();
	  }
	}
