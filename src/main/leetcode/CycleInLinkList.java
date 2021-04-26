package main.leetcode;

import java.util.List;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class CycleInLinkList {


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if (head.next == null) return null;

        slow = slow.next;
        fast = fast.next.next;

        if (fast == null) return null;

        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else return null;
        }


        if (slow != null && fast != null && slow == fast) {

            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }


        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(new CycleInLinkList().detectCycle(head));
    }
}
