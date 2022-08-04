package BinaryTree;

import java.util.*;
import java.io.*;

public class DiagonalOrderInBinaryTree {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	    	
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
	        
	    	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	    	LinkedList<TreeNode> que = new LinkedList<>();
	    	que.addLast(root);
	    	
	    	while(que.size() != 0) { 
	    		
	    		int size = que.size();
	    		ArrayList<Integer> smallans = new ArrayList<>();
	    		
	    		while(size-- > 0) {
	    			
	    			TreeNode remove_node = que.removeFirst();
	    			
	    			while(remove_node != null) {
	    				
	    				smallans.add(remove_node.val);
	    				
	    				if(remove_node.left != null) que.addLast(remove_node.left);
	    					
	    					remove_node = remove_node.right;
	    			}
	    		}
	    		ans.add(smallans);
	    	}
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

	        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
	        int idx = 0;
	        for (ArrayList<Integer> i : ans) {
	            System.out.print(idx++ + " -> ");
	            for (Integer j : i)
	                System.out.print(j + " ");
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}
