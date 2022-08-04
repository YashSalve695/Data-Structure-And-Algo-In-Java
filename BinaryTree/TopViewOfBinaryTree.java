package BinaryTree;

import java.util.*;
import java.io.*;

public class TopViewOfBinaryTree {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
        
	    public static void width(TreeNode root, int hl, int minMax[]) {
	    	
	    	if(root == null) {
	    		return;
	    	}
	    	
	    	minMax[0] = Math.min(minMax[0], hl);
	    	minMax[1] = Math.max(minMax[1], hl);
	    	
	    	width(root.left, hl - 1, minMax);
	    	width(root.right, hl + 1, minMax);
	    	
	    }
	    
	    public static class vPair {
	    	
	    	TreeNode node = null;
	    	int hl = 0;
	    	
	    	public vPair(TreeNode node, int hl) {
				
	    		this.node = node;
	    		this.hl = hl;
			}
	    }
	    
	    public static ArrayList<Integer> TopView(TreeNode root) {
	   
	    	ArrayList<Integer> ans = new ArrayList<>();
	    	LinkedList<vPair> que = new LinkedList<>();
	    	
	    	if(root == null) {
	    		return ans;
	    	}
	    	 
	    	int minMax[] = new int[2];
	    	width(root, 0, minMax);
	    	
	    	int length_of_tree = minMax[1] - minMax[0] + 1;
	    	
	    	 for(int i = 0; i < length_of_tree; i++) {
	    		 ans.add(null);
	       /** iterating through the length of tree in arrayList
	           and marking all the values intially null */
	    	 }
             
	    	 que.addLast(new vPair(root, -minMax[0]));
	    	 
	    	 while(que.size() != 0) {
	    		 int size = que.size();
	    		 
	    		 while(size-- > 0) {
	    			 
	    			 vPair remove_pair = que.removeFirst();
	    			 
	    			 TreeNode node = remove_pair.node;
	    			 int hl = remove_pair.hl;
	    			 
	    	if(ans.get(hl) == null) ans.set(hl, node.val);
	    	
	    	if(node.left != null) {
	    		que.addLast(new vPair(node.left, hl - 1));
	    	}
	    	
	    	if(node.right != null) {
	    		que.addLast(new vPair(node.right, hl + 1));
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

	        ArrayList<Integer> ans = TopView(root);
	        for (Integer i : ans)
	            System.out.print(i + " ");

	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}

// 21
// 1 2 7 8 -1 -1 -1 9 -1 -1 6 10 -1 -1 11 -1 12 -1 13 -1 -1