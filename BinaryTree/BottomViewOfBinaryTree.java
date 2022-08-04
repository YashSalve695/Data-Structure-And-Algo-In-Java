

import java.util.*;
import java.io.*;

public class BottomViewOfBinaryTree {

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
	        int hl = 0; // horizontal Level

	        verticalPair(TreeNode node, int hl) {
	            this.node = node;
	            this.hl = hl;
	        }
	    }

	    // ans = {minHl,maxHL}
	    public static void width(TreeNode root, int hl, int[] ans) {
	        if (root == null)
	            return;

	        ans[0] = Math.min(hl, ans[0]);
	        ans[1] = Math.max(hl, ans[1]);

	        width(root.left, hl - 1, ans);
	        width(root.right, hl + 1, ans);
	    }

	    public static ArrayList<Integer> BottomView(TreeNode root) {
	        LinkedList<verticalPair> que = new LinkedList<>();

	        int[] minMax = new int[2];
	        width(root, 0, minMax);
	        
	        int length = minMax[1] - minMax[0] + 1;
	        /** width of the binary tree */
	        
	        ArrayList<Integer> ans = new ArrayList<>();
	        for (int i = 0; i < length; i++)
	            ans.add(0);
	        /** Default value intially*/

	        que.addLast(new verticalPair(root, -minMax[0]));

	        while (que.size() != 0) {
	            int size = que.size();
	            
	            while (size-- > 0) {
	            	
	                verticalPair remove_pair = que.removeFirst();

	                ans.set(remove_pair.hl, remove_pair.node.val);

	                if (remove_pair.node.left != null)
	                    que.addLast(new verticalPair(remove_pair.node.left, remove_pair.hl - 1));

	                if (remove_pair.node.right != null)
	                    que.addLast(new verticalPair(remove_pair.node.right, remove_pair.hl + 1));
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

	        ArrayList<Integer> ans = BottomView(root);
	        for (Integer i : ans)
	            System.out.print(i + " ");

	    }

	    public static void main(String[] args) {
	        solve();
	    }
	}

//15
//50 25 12 -1 -1 37 -1 -1 75 62 -1 -1 87 -1 -1