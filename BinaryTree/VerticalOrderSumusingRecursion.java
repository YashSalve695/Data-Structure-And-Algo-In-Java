package BinaryTree;

import java.util.*;
import java.io.*;

public class VerticalOrderSumusingRecursion {

	public class VerticalOrderSumUsingBFS {

		  public static Scanner scn = new Scanner(System.in);

		    public static class TreeNode {
		        int val = 0;
		        TreeNode left = null;
		        TreeNode right = null;

		        TreeNode(int val) {
		            this.val = val;
		        }
		    }

		    public static void width(TreeNode root, int hl, int MinMax[]) {
		    	
		    	if(root == null) {
		    		return;
		    	}
		    	
		    	MinMax[0] = Math.min(hl, MinMax[0]);
		    	MinMax[1] = Math.max(hl, MinMax[1]);
		    	
		    	width(root.left, hl - 1, MinMax);
		    	width(root.right, hl + 1, MinMax);
		    	
		    }
		    
		   public static void dfs(TreeNode root, int hl, ArrayList<Integer> ans) {
			   
			   if(root == null) {
				   return;
			   }
			   
			   ans.set(hl, ans.get(hl) + root.val);
			   
			   dfs(root.left, hl - 1, ans);
			   dfs(root.right, hl + 1, ans);
			   
		   }
		   
		   private static ArrayList<Integer> verticalOrderSum(TreeNode root){
			   
			   int width[] = new int[2];
			   width(root, 0, width);
			   
			   int len_of_tree = width[1] - width[0] + 1;
			   
			   ArrayList<Integer> ans = new ArrayList<>();
			    for(int i = 0; i < len_of_tree; i++) ans.add(0);
			    
			    dfs(root, -width[0], ans);
			    
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

		        ArrayList<Integer> ans = verticalOrderSum(root);
		        for (Integer j : ans)
		            System.out.println(j);

		    }

		    public static void main(String[] args) {
		        solve();
		    }
		}
