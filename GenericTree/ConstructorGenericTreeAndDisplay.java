package GenericTree;

import java.util.*;

public class ConstructorGenericTreeAndDisplay {

	private static class Node{
		
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static void constructGenericTree(int arr[]) {
		
		 Node root = null;
		 Stack<Node> st = new Stack<>();
		 
		for(int i = 0; i < arr.length; i++) {
			int val = arr[i];
			
			if(val == -1) {
				st.pop();
				
			} else {
				
				Node node = new Node();
				node.data = val;
				
				if(st.size() > 0) {
				st.peek().children.add(node);
	              
				} else {
					
					root = node;
				}
				st.push(node);
	         }
		}
		display(root);
	
	}
	
	public static void display(Node root) {
	    
		String str = root.data + " -> ";
		   for(Node child : root.children) {
			   str += child.data + ",";
		   }
		   str += ".";
		   System.out.println(str);
		   
		   for(Node child : root.children) {
			   display(child); // Recursive call
		   }
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		 for(int i = 0; i < n; i++) {
			 arr[i] = sc.nextInt();
		 }
		 constructGenericTree(arr);
		
	}
}

// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

