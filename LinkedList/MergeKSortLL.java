package LinkedList;

import java.util.*;

public class MergeKSortLL {

	 public static Scanner scn = new Scanner(System.in);

	    public static class Node {
	        int val = 0;
	        Node next = null;

	       Node(int val) {
	            this.val = val;
	        }
	    }

	    public static Node MergetwoLL(Node l1,Node l2) {
	    	 
	    	if(l1 == null || l2 == null)return l1 != null ? l1 : l2;
	    	
	    	Node c1 = l1;
	    	Node c2 = l2;
	    	Node dummy = new Node(-1);
	    	Node prev = dummy;
	    	
	    	while(c1 != null && c2 != null) {
	    		
	    		if(c1.val < c2.val) {
	    			prev.next = c1;
	    			c1 = c1.next;
	    		}else {
	    			prev.next = c2;
	    			c2 = c2.next;
	    		}
	    		prev = prev.next;
	    	}
	    	prev.next = c1 != null ? c1 : c2;
	    	return dummy.next;
	    }
	
	    public static Node  mergeKLists(Node list[]) {
	    	
	    	if(list.length == 0) {
	    		return null;
	    	}
	    	return  mergeKLists(list,0,list.length - 1);
	    }
	  
	    public static Node mergeKLists(Node[] lists,int startindex,int lastindex) {
	       
	    	if(startindex > lastindex) {
	    		return null;
	    	}
	    	if(startindex == lastindex) {
	    		return lists[startindex];
	    	}
	    	
	    	int mid = (startindex + lastindex) / 2;
	    	
	    	Node l1 = mergeKLists(lists,startindex,mid);
	    	Node l2 = mergeKLists(lists,mid + 1,lastindex);
	    	
	    	return MergetwoLL(l1,l2);
	  
	    }

	    public static Node mergeLists(Node lists[]) {
	    	
	    	PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
	    		  return a.val - b.val;
	    	//	  return b.val - a.val;
	    	});
	    	
	    	 for(Node l : lists) if(l != null) pq.add(l);
	    	 
	    	 Node dummy = new Node(-1);
	    	 Node prev = dummy;
	    	 
	    	 while(pq.size() != 0) {
	    		 
	    		 Node node = pq.remove();
	    		 prev.next = node;
	    		 prev = prev.next;
	    		 node = node.next;
	    		 
	    		 if(node != null) pq.add(node);
	    	 }
	    	 return dummy.next;
	    }
	    
	    public static void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	    }

	    public static Node createList(int n) {
	        Node dummy = new Node(-1);
	        Node prev = dummy;
	        while (n-- > 0) {
	            prev.next = new Node(scn.nextInt());
	            prev = prev.next;
	        }

	        return dummy.next;
	    }

	    public static void main(String[] args) {
	     
	    	int n = scn.nextInt();
	        Node[] list = new Node[n];
	        for (int i = 0; i < n; i++) {
	            int m = scn.nextInt();
	            list[i] = createList(m);
	        }
     Node head = mergeLists(list);
	   //     Node head = mergeKLists(list);
	        printList(head);
	    }
	}
