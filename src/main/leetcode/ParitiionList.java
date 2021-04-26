package main.leetcode;

public class ParitiionList {


    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);
        ListNode sIt = smallerHead;
        ListNode gIt = greaterHead;

        ListNode it = head;
        while (it != null) {
            if (it.val < x) {
                // for smaller values
                sIt.next = it;
                it = it.next;
                sIt = sIt.next;
            } else {
                // for equal or greater comparisons
                gIt.next = it;
                it = it.next;
                gIt = gIt.next;
            }
        }

        sIt.next = greaterHead.next;
        gIt.next = null;

        return smallerHead.next;

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));

        System.out.println(new ParitiionList().partition(root, 3));
    }
}
