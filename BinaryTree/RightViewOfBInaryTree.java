package BinaryTree;

import java.util.*;

public class RightViewOfBInaryTree {

	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	    public static ArrayList<Integer> rightView(TreeNode root) {
	       
	    	ArrayList<Integer> ans = new ArrayList<>();
	    	
	    	LinkedList<TreeNode> queue = new LinkedList<>();
	    	queue.addLast(root);
	    	
	    	while(queue.size() != 0) {
	    		
	    		int size = queue.size();
	    		ans.add(queue.getFirst().val);
	    		
	    		while(size-- > 0) {
	    			
	    			TreeNode removenode = queue.removeFirst();
	    			
	    			if(removenode.right != null) queue.addLast(removenode.right);
	    			if(removenode.left != null) queue.addLast(removenode.left);
	    			
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

	        ArrayList<Integer> ans = rightView(root);
	        for(Integer i : ans) System.out.println(i); 
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}

// 21
// 1 2 7 8 -1 -1 -1 9 -1 -1 6 10 -1 -1 11 -1 12 -1 13 -1 -1