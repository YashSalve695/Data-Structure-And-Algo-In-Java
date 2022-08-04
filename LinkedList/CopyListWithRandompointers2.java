package LinkedList;

import java.util.*;

public class CopyListWithRandompointers2 {

	 public static class Node {
        int val = 0;
        Node next = null;
        Node random = null;

        Node(int val) {
            this.val = val;
        }
    }
   
	public static void copyList(Node head) {
		
		Node curr = head;
		
		while(curr != null) {
			
			Node forward = curr.next;
			
			Node node = new Node(curr.val);
			curr.next = node;
			node.next = forward;
			
			curr = forward;
		}
	}
	
	public static void copyRandompointers(Node head) {
		
		Node curr = head;
		
		while(curr != null) {
			
			Node random = curr.random;
			
			if(random != null) {
				
				curr.next.random = random.next;
				curr = curr.next.next;
			}
		}
	}
	
	public static Node extractDeepcopy(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		Node dummy = new Node(-1);
		Node prev = dummy;
		Node curr = head;
		
		while(curr != null) {
			
			prev.next = curr.next;
			curr.next = curr.next.next;
			
			prev = prev.next;
			curr = curr.next;
		}
		return dummy.next;
	}
	
    public static Node copyRandomList(Node head) {
     
    	copyList(head);
    	copyRandompointers(head);
    	
    	return extractDeepcopy(head);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        Node[] arr = new Node[n];
        Node prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        Node head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}