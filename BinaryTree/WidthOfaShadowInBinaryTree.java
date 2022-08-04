package BinaryTree;

import java.util.*;

public class WidthOfaShadowInBinaryTree {

	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    /** hl -> horizontal level. */ 
    private static void getWidth(TreeNode root, int hl, int ans[]) {
    	
       if(root == null) {
    	   return;
       }
       
       ans[0] = Math.min(ans[0], hl); 
       /** It will store the min */
       
       ans[1] = Math.max(ans[1], hl);
       /** It will store the max */
       
       getWidth(root.left, hl - 1, ans);
       /** while going to left -1 */
       
       getWidth(root.right, hl + 1, ans);
       /** while going to right 1 */
       
    }
    
    public static int width(TreeNode root) {
       
    	int widt[] = new int[2];
    	getWidth(root, 0, widt);
    	
    	return widt[1] - widt[0] + 1;
    	/** FORMULA OF WIDTH = b - a + 1 */
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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
// 21
// 1 2 7 8 -1 -1 -1 9 -1 -1 6 10 -1 -1 11 -1 12 -1 13 -1 -1


