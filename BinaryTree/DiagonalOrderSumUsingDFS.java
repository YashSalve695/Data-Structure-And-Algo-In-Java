package BinaryTree;

import java.util.*;
import java.io.*;

public class DiagonalOrderSumUsingDFS {

	 public static Scanner scn = new Scanner(System.in);

	  public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    TreeNode(int val) {
	      this.val = val;
	    }
	  }
	  
	  public static void dfs(TreeNode node, int diaNo, ArrayList<Integer> ans) {
		  
		  if(node == null) {
			  return;
		  }
		  
		  if(diaNo == ans.size()) ans.add(0);
		  
		  ans.set(diaNo, ans.get(diaNo) + node.val);
		  
		  dfs(node.left, diaNo + 1, ans);
		  // while going in left side always do +1;
		  dfs(node.right, diaNo + 0, ans);
		  // while going in right side always do 0;
	  }

	  public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {

	    ArrayList<Integer> ans = new ArrayList<>();
	    
	    dfs(root, 0, ans);
	    
	    return ans;
	  }

	 

	  public static TreeNode createTree(int[] arr, int[] IDX) {
	    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
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

	    ArrayList<Integer> ans = diagonalOrderSum(root);
	    for (Integer j : ans)
	      System.out.print(j + " ");

	  }

	  public static void main(String[] args) {
	    solve();
	  }
	}


