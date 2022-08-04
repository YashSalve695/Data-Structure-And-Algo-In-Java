package BinaryTree;

import java.util.*;
import java.io.*;

public class VerticalOrderOfBinarytTree2 {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
	    
	    public static class verticalPair{
	    	
	    	TreeNode node = null;
	    	int hl = 0;
	    	
	    	 verticalPair(TreeNode node, int hl) {
				
	    		 this.node = node;
	    		 this.hl = hl;
			}
	    }
         
	   /** This function will use to find the width of binary tree */
	    public static void width(TreeNode root, int hl, int ans[]) {
	    	
	    	if(root == null) {
	    		return;
	    	}
	    	 
	    	ans[0] = Math.min(ans[0], hl);
	    	ans[1] = Math.max(ans[1], hl);
	    	
	    	width(root.left, hl - 1, ans);
	    	/** while going in left side always do -1 */
	    	
	    	width(root.right, hl + 1, ans);
	    	/** while going in right side always do +1 */
	    }
	    
	    private static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
	        
	    	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	    	
	    	if(root == null) {
	    		return ans;
	    	} /** BASE CASE */
              
	    int min_max[] = new int[2];
	    width(root, 0, min_max);
	    
	    int len = min_max[1] - min_max[0] + 1;
	    /** This will gave the length of binary tree */
	    
	    for(int i = 0; i < len; i++) {
	    	ans.add(new ArrayList<>());
	    }
	    
	    LinkedList<verticalPair> que = new LinkedList<>();
	    que.add(new verticalPair(root, Math.abs(min_max[0])));
	    
	    while(que.size() != 0) {
	    	
	    	int size = que.size();
	    	
	    	while(size-- > 0) {
	    		
	    		verticalPair removepPair = que.removeFirst();
	    		int horizontallevel = removepPair.hl;
	    		TreeNode node = removepPair.node;
	    		
	    		ans.get(horizontallevel).add(node.val);
	    		
	    		if(node.left != null) {
	    			que.addLast(new verticalPair(node.left, horizontallevel - 1));
	    		}
	    		
	    		if(node.right != null) {
	    			que.addLast(new verticalPair(node.right, horizontallevel + 1));
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

	        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
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

// 29
// 3 1 0 -1 -1 2 -1 -1 6 5 4 -1 -1 15 -1 -1 10 9 12 13 -1 -1 14 -1 -1 -1 11 -1 -1