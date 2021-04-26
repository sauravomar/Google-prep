package main.leetcode;

public class RemoveSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next != null) return head;

        ListNode temp = head.next;
        ListNode result = null;
        ListNode prev = null;
        boolean isFirst = true;

        int oldVal = head.val;

        if (temp.val != oldVal) {
            prev = new ListNode(oldVal);
            result = prev;
            isFirst = false;
        }


        while (temp != null) {
            if (temp.val == oldVal || (temp.next != null && temp.val == temp.next.val)) {
                oldVal = temp.val;
                temp = temp.next;
                continue;
            }

            if (isFirst) {
                prev = new ListNode(temp.val);
                result = prev;
                isFirst = false;
            } else {
                prev.next = new ListNode(temp.val);
                prev = prev.next;
            }
            oldVal = temp.val;
            temp = temp.next;
        }

        return result;


    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
//        head1.next = new ListNode(2);
//        head1.next.next = new ListNode(3);
//        head1.next.next.next = new ListNode(3);
//        head1.next.next.next.next = new ListNode(4);
//        head1.next.next.next.next.next = new ListNode(4);
//        head1.next.next.next.next.next.next = new ListNode(5);

        ListNode result = new RemoveSortedList().deleteDuplicates(head1);

        System.out.println(result);

    }
}
