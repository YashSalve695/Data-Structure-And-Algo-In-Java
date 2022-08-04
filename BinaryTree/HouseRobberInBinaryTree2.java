package BinaryTree;

import java.util.*;

public class HouseRobberInBinaryTree2 {
	
	 public static Scanner scn = new Scanner(System.in);

	    public static class TreeNode {
	        int val = 0;
	        TreeNode left = null;
	        TreeNode right = null;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }

	   
	    
	    private static int[] houserob(TreeNode root) {
	    	
	    	if(root == null) {
	    		return new int[2];
	    	}
	    	
	    	int lefthouse[] = houserob(root.left);
	    	int righthouse[] = houserob(root.right);
	    	
	    	int ans[] = new int[2];
	    	
	    	ans[0] = lefthouse[1] + root.val + righthouse[1];
	    	ans[0] = Math.max(lefthouse[0], lefthouse[1]) +
	    			 Math.max(righthouse[0], righthouse[1]);
	    	
	    	return ans;
	    	
	    } 
	    
	    public static int HouseRobber(TreeNode root) {
	        
	    	int res[] = houserob(root);
	    	
	    	return Math.max(res[0], res[1]);
	    	
	    	
	    }

	   
	    public static TreeNode createTree(int[] arr, int[] IDX) {
	        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
	        System.out.println(HouseRobber(root));
	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}

 /**15
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