package main.leetcode;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null, prev = null;
        int i = 0;

        while (l1 != null || l2 != null) {
            ListNode smaller = (l1 == null) ? l2 : (l2 == null ? l1 : (l1.val < l2.val ? l1 : l2));
            if (i == 0)
                head = smaller;
            else {
                prev.next = smaller;
            }

            if (smaller == l1) l1 = l1.next;
            if (smaller == l2) l2 = l2.next;
            prev = smaller;

            i++;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode result = new MergeTwoSortedList().mergeTwoLists(head1, head2);

        System.out.println(result);

    }
}
