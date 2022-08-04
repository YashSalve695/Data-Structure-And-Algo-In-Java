package LinkedList;

import java.util.*;

public class IsCyclePresentInLinkedlist {

	public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean isCyclePresentInLL(Node head) {

       if(head == null || head.next == null) {
    	   return false;
       }
       Node slow = head;
       Node fast = head;
       
       while(fast != null && fast.next != null) {
    	   
    	   slow = slow.next;
    	   fast = fast.next.next;
    	   
    	   if(slow == fast) return true;
       }
       return false;
    }

    public static Node takeInput() {
    	
        int n = scn.nextInt();
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            prev.next = new Node(scn.nextInt());
            prev = prev.next;
        }
        int idx = scn.nextInt();
        if (idx >= 0) {
            Node curr = dummy.next;
            while (idx-- > 0) {
                curr = curr.next;
            }
            prev.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = takeInput();
        System.out.println(isCyclePresentInLL(head));
    }
}