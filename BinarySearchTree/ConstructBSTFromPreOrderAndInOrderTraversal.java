package BinarySearchTree;

import java.util.*;

public class ConstructBSTFromPreOrderAndInOrderTraversal {

	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode constructFromPreAndIn(int preOrder[], int preStartindex,
    		                                      int preEndindex, int inOrder[],
    		                                      int inStartindex, int inEndindex) {
    	
    	if(inStartindex > inEndindex) {
    		return null;
    	}
    	
    	/** In preorder traversal rootNode is always at 0 index in array */
    	/** In InOrder traversal rootnode is always at mid  in array */
    	/** In postOrtder traversal rootnode is always at end index in the array */
    	
    	int index = inStartindex;
    	
    	while(inOrder[index] != preOrder[preStartindex]) index++;
    	int count = index - inStartindex;
    	   
    	TreeNode node = new TreeNode(preOrder[preStartindex]);
    	
    	node.left = constructFromPreAndIn(preOrder, preStartindex + 1, preStartindex + count, 
    			                          inOrder,inStartindex, index - 1);
    	
    	node.right = constructFromPreAndIn(preOrder, preStartindex + count + 1, preEndindex, 
    			                           inOrder, index + 1, inEndindex);
    	
    	return node;
    	
    }
    
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        
    	int n = preorder.length;
    	
    	return constructFromPreAndIn(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}


// 7
// 4 2 1 3 6 5 7
// 1 2 3 4 5 6 7

