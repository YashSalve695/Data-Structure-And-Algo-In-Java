package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

import BinaryTree.NodeToRootPathInBT.TreeNode;

public class NodeToRootPath2 {

	public static Scanner scn = new Scanner(System.in);

	  public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    TreeNode(int val) {
	      this.val = val;
	    }
	  }
     
	  /** FIND FUNCTION */
	  public static ArrayList<TreeNode> find(TreeNode root, int data){
		  
		  if(root == null) {
			  return null;
		  }
		  
		  if(root.val == data) {
			  ArrayList<TreeNode> res = new ArrayList<>();
			  res.add(root);
			  return res;
		  }
		  
		  ArrayList<TreeNode> left = find(root.left, data);
		  if(left != null) {
			  left.add(root);
			  return left;
		  }
		  
		  ArrayList<TreeNode> right= find(root.right, data);
		  if(right != null) {
			  right.add(root);
			  return right;
		  }
		  
		  return null;
	  }
	 
	  
	  public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
	   
		  ArrayList<TreeNode> res = find(node, data);
		  
		  return res != null ? res : new ArrayList<>();
		  
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

	    int data = scn.nextInt();
	    ArrayList<TreeNode> ans = nodeToRootPath(root, data);
	    if (ans.size() == 0)  System.out.println();
	    for (TreeNode node : ans)
	      System.out.print(node.val + " ");

	  }

	  public static void main(String[] args) {
	    solve();
	  }
	}


/** 15
4
2
1
-1
-1
3
-1
-1
6
5
-1
-1
7
-1
-1
5 */

