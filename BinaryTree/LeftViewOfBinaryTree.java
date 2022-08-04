

import java.util.*;

public class LeftViewOfBinaryTree {

	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> leftView(TreeNode root) {
       
    	if(root == null) {
    		return null;
    	}
    	
    	ArrayList<Integer> ans = new ArrayList<>();
    	
    	LinkedList<TreeNode> queue = new LinkedList<>();
    	queue.addLast(root);
    	/** Add last in the queue */
    	
    	while(queue.size() != 0) {
    		
    		int size = queue.size();
    		ans.add(queue.getFirst().val);
    		
    		while(size-- > 0) {
    			
    			TreeNode rightnode = queue.removeFirst();
    			
    			if(rightnode.left != null) queue.addLast(rightnode.left);
    			if(rightnode.right != null) queue.addLast(rightnode.right);
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

        ArrayList<Integer> ans = leftView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}

// 15
// 50 25 12 -1 -1 37 -1 -1 75 62 -1 -1 87 -1 -1




