package main.leetcode;

import java.util.List;

public class SwappingNodesInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return head;

        ListNode temp = head;
        int totalNodes = 0;

        while (temp != null) {
            totalNodes++;
            temp = temp.next;
        }

        if (k > totalNodes) return head;

        ListNode lastNode = head;

        int iterator = totalNodes - k;

        while (iterator > 1) {
            iterator--;
            lastNode = lastNode.next;
        }

        temp = head;
        iterator = k;

        while (iterator > 1) {
            iterator--;
            temp = temp.next;
        }
        int val = temp.val;
        temp.val = lastNode.val;
        lastNode.val = val;

        String str[] = new String[10];


        return head;


    }


    public static void main(String[] args) {


        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(new SwappingNodesInALinkedList().swapNodes(root, 2));
    }

}
