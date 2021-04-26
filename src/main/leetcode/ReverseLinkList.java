package main.leetcode;

public class ReverseLinkList {
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(7);
        list.next = new ListNode(5);
        list.next.next = new ListNode(9);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(6);
        System.out.println(new ReverseLinkList().reverse(list));
    }
}
