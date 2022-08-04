package BinaryTree;

import java.util.*;
import java.io.*;

import BinaryTree.DiagonalOrderSumUsingDFS.TreeNode;

public class DiagonalOrderumUsingBFS {

	public static Scanner scn = new Scanner(System.in);

	  public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    TreeNode(int val) {
	      this.val = val;
	    }
	  }
	  
	  

	  public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {

	    LinkedList<TreeNode> que = new LinkedList<>();
	    que.addLast(root);
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    while(que.size() != 0) {
	    	
	    	int size = que.size();
	    	int sum = 0;
	    	
	    	while(size-- > 0) {
	    		
	    		TreeNode remove_node = que.removeFirst();
	    		
	    		while(remove_node != null) sum += remove_node.val;
	    		
	    		if(remove_node.left != null) que.addLast(remove_node.left);
	    		
	    		remove_node = remove_node.right;
	    	}
	    	res.add(sum);
	    }
	    return res;
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
-1 */

