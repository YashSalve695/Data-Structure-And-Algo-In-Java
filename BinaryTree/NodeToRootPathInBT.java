package BinaryTree;

import java.util.*;
import java.io.*;

public class NodeToRootPathInBT {

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
	  public static boolean find(TreeNode root, int data, ArrayList<TreeNode> res) {
		  
		  if(root == null) return false;
		  
		  if(root.val == data) {
			  res.add(root);
			  return true;
		  }
		  
		  boolean find = find(root.left, data, res) || find(root.right, data, res);
		  
		  if(find == true) {
			  res.add(root);
		  }
		  return find;
	  }
	  
	  public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
	   
		  ArrayList<TreeNode> ans = new ArrayList<>();
		  
		  find(node, data, ans);
		  
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
