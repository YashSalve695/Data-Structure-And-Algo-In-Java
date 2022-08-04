package BinaryTree;

import java.util.*;

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
	    
	    public static class Vpair {
	    	
	    	TreeNode node = null;
	    	int hl = 0;
	    	
	    	Vpair(TreeNode node, int hl){
	    		
	    		this.node = node;
	    		this.hl = hl;
	    	}
	    }
	    
	    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
	       
	    	int width[] = new int[2];
	    	width(root, 0, width);
	    	
	    	int tree_len = width[1] - width[0] + 1;
	    	
	    	ArrayList<Integer> ans = new ArrayList<>();
	    	 for(int i = 0; i < tree_len; i++) ans.add(0);
	    	// Make Arraylist of size tree_len, and intially add 0 to all the arraylist
	    	 
	    	 LinkedList<Vpair> que = new LinkedList<>();
	    	 que.add(new Vpair(root, -width[0]));
	    	 
	    	 while(que.size() != 0) {
	    		 
	    		 int size = que.size();
	    		 
	    		 while(size-- > 0) {
	    			 
	    			 Vpair remove_node = que.removeFirst();
	    			 
	    			 TreeNode node = remove_node.node;
	    			 int hl = remove_node.hl;
	    			 
	    			 ans.set(hl, ans.get(hl) + node.val);
	    			 
	    			 if(node.left != null) {
	    				 que.addLast(new Vpair(node.left, hl - 1));
	    			 }
	    			 
	    			 if(node.right != null) {
	    				 que.addLast(new Vpair(node.right, hl + 1));
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

	        ArrayList<Integer> ans = verticalOrderSum(root);
	        for (Integer j : ans)
	            System.out.println(j);

	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}

// 21
// 1 2 4 7 -1 -1 8 -1 9 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1