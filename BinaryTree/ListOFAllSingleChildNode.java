package BinaryTree;

import java.util.*;
import java.io.*;

public class ListOFAllSingleChildNode {

	 public static Scanner scn = new Scanner(System.in);

	  public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    TreeNode(int val) {
	      this.val = val;
	    }
	  }
	  
	  private static void one_child(TreeNode root, ArrayList<Integer> res) {
		  
		  if(root == null || (root.left == null && root.right == null)) {
			  return;
		  }
		  
		  if(root.left == null || root.right == null) {
			  res.add(root.val);
		  }
		  
		  one_child(root.left, res);
		  one_child(root.right, res);
	  }

	  public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
	    ArrayList<Integer> ans = new ArrayList<>();
	    one_child(root, ans);
	    
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

	    ArrayList<Integer> ans = exactlyOneChild(root);
	    if (ans.size() == 0)
	      System.out.println();
	    for (Integer ele : ans)
	      System.out.print(ele + " ");
	  }

	  public static void main(String[] args) {
	    solve();
	  }
	}