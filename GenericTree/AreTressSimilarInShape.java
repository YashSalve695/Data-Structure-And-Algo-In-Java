package GenericTree;

import java.util.*;
import java.io.*;

public class AreTressSimilarInShape {

	 private static class Node {
		    int data;
		    ArrayList<Node> children = new ArrayList<>();
		  }

		  public static void display(Node node) {
		    String str = node.data + " -> ";
		    for (Node child : node.children) {
		      str += child.data + ", ";
		    }
		    str += ".";
		    System.out.println(str);

		    for (Node child : node.children) {
		      display(child);
		    }
		  }

		  public static Node construct(int[] arr) {
		    Node root = null;

		    Stack<Node> st = new Stack<>();
		    for (int i = 0; i < arr.length; i++) {
		      if (arr[i] == -1) {
		        st.pop();
		      } else {
		        Node t = new Node();
		        t.data = arr[i];

		        if (st.size() > 0) {
		          st.peek().children.add(t);
		        } else {
		          root = t;
		        }

		        st.push(t);
		      }
		    }

		    return root;
		  }

		  public static int size(Node root) {
			  
			  if(root == null) {
				  return 0;
			  }
			  
			  int max = 0;
			  
			  for(Node child : root.children) {
				  int childheight = size(child);
				  max = Math.max(max, childheight);
			  }
			  return max + 1;
		  }
		

		  public static boolean areSimilar(Node n1, Node n2) {
		   
			  if(n1.children.size() != n2.children.size()) {
				  return false;
			  }
			  
			  for(int i = 0; i < n1.children.size(); i++) {
				  Node child1 = n1.children.get(i);
				  Node child2 = n2.children.get(i);
				  
				  if(areSimilar(child1, child2) == false) {
					  return false;
				  }
				 
			  }
			  return true;
		  }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    int n1 = Integer.parseInt(br.readLine());
		    int[] arr1 = new int[n1];
		    String[] values1 = br.readLine().split(" ");
		    for (int i = 0; i < n1; i++) {
		      arr1[i] = Integer.parseInt(values1[i]);
		    }
		    Node root1 = construct(arr1);

		    int n2 = Integer.parseInt(br.readLine());
		    int[] arr2 = new int[n2];
		    String[] values2 = br.readLine().split(" ");
		    for (int i = 0; i < n2; i++) {
		      arr2[i] = Integer.parseInt(values2[i]);
		    }
		    Node root2 = construct(arr2);

		    boolean similar = areSimilar(root1, root2);
		    System.out.println(similar);
		  }

		}

/** 24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
24
1 2 5 -1 6 -1 -1 3 7 -1 8 11 -1 12 -1 -1 9 -1 -1 4 10 -1 -1 -1 */
