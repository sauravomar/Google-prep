package main.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;

        ListNode intermediate = null;


        if (lists.length == 0) return result;
        PriorityQueue<ListNode> pq
                = new PriorityQueue<ListNode>(
                new Comparator<ListNode>() {
                    public int compare(ListNode a, ListNode b) {
                        return a.val - b.val;
                    }
                }
        );


        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.add(lists[i]);


        while (!pq.isEmpty()) {
            ListNode node = pq.remove();

            if (result == null) {
                intermediate = new ListNode(node.val);
                result = intermediate;
            } else {
                intermediate.next = new ListNode(node.val);
                intermediate = intermediate.next;
            }


            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode arr[] = new ListNode[3];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);

        ListNode result = new MergeKSortedList().mergeKLists(arr);

        System.out.println(result);
    }
}
