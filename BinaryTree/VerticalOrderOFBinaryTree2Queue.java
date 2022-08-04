package BinaryTree;

import java.util.*;

import org.w3c.dom.Node;

import java.io.*;

public class VerticalOrderOFBinaryTree2Queue {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
	    
	    public static void width(TreeNode node, int hl, int Min_Max[]) {
	    	
	    	if(node == null) {
	    		return;
	    	}
	    	
	    	Min_Max[0] = Math.min(Min_Max[0], hl);
	    	Min_Max[1] = Math.max(Min_Max[1], hl);
	    	
	       width(node.left, hl  - 1, Min_Max);
	       width(node.right, hl + 1, Min_Max);
	    }

	    public static class Vpair {
	    	
	    	TreeNode node = null;
	    	int hl = 0;
	    	
	    	public Vpair(TreeNode node, int hl) {
				
	    		this.node = node;
	    		this.hl = hl;
			}
	    }
	    
	    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
	       
	    	PriorityQueue<Vpair> parent_Que = new PriorityQueue<>((a,b) ->{
	    		return a.node.val - b.node.val;
	    	});
	    	
	    	PriorityQueue<Vpair> child_Que = new PriorityQueue<>((a,b) ->{
	    		return a.node.val - b.node.val;
	    	});
	    	
	    	int MinMax[] = new int[2];
	    	width(root, 0, MinMax);
	    	
	    	int len_of_tree = MinMax[1] - MinMax[0] + 1;
	    	
	    	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	    	 for(int i = 0; i < len_of_tree; i++) ans.add(new ArrayList<>());
	    	 
	    		 parent_Que.add(new Vpair(root, -MinMax[0]));
	    		 
	    		 while(parent_Que.size() != 0) {
	    			 
	    			 int size = parent_Que.size();
	    			 
	    			 while(size-- > 0) {
	    				 
	    				 Vpair remove_node = parent_Que.remove();
	    				 TreeNode node = remove_node.node;
	    				 int hl = remove_node.hl;
	    				 
	    				 ans.get(hl).add(node.val);
	    				 
	    				 if(node.left != null) {
	    					 child_Que.add(new Vpair(node.left, hl - 1));
	    				 }
	    				 
	    				 if(node.right != null) {
	    					 child_Que.add(new Vpair(node.right, hl + 1));
	    				 }
	    				 
	    			 }
	    			 /** This is use to swap values or transfer it into parent que */
					 PriorityQueue<Vpair> temp = parent_Que;
					 parent_Que = child_Que;
					 child_Que = temp;
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
