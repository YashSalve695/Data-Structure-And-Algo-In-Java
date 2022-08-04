package BinaryTree;

import java.util.*;
import java.io.*;

public class VerticalOrderOfBinaryTree {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	    public static class verticalPair {
	    	
	    	TreeNode node = null;
	    	int horizontallevel = 0;
	    	
	    	verticalPair(TreeNode node, int horizontallevel){
	    		
	    		this.node = node;
	    		this.horizontallevel = horizontallevel;
	    	}
	    }
	    
	    public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
	        
	    	LinkedList<verticalPair> que = new LinkedList<>();
	    	HashMap<Integer, List<Integer>> map = new HashMap<>();
	    	
	    	int minhl = 0;
	    	int maxhl = 0;
	    	
	    	List<List<Integer>> ans = new ArrayList<>();
	    	
	    	que.addLast(new verticalPair(root, 0));
	    	
	    	while(que.size() != 0) {
	    		int size = que.size();
	    		
	    		while(size-- > 0) {
	    			
	    			verticalPair removePair = que.removeFirst();
	    			
	    			minhl = Math.min(minhl,removePair.horizontallevel);
	    			maxhl = Math.max(maxhl, removePair.horizontallevel);
	    			
	    			map.putIfAbsent(removePair.horizontallevel, new ArrayList<>());
	    			map.get(removePair.horizontallevel).add(removePair.node.val);
	    			
	    	if(removePair.node.left != null) {
	    		que.addLast(new verticalPair(removePair.node.left, removePair.horizontallevel - 1));
	    	    	}
	    	
	    	if(removePair.node.right != null) {
	    		que.addLast(new verticalPair(removePair.node.right, removePair.horizontallevel + 1));
	    	    	}
	    		}
	    	}
	    	for(int i = minhl; i <= maxhl; i++) {
	    		ans.add(map.get(i));
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

	        List<List<Integer>> ans = verticalOrderTraversal(root);
	        int idx = 0;
	        for (List<Integer> i : ans) {
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

 

/** 15
1
1
-1
1
1
-1
1
-1
-1
1
-1
-1
1
-1
-1 */