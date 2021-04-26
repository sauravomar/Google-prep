package main.leetcode;

import java.util.List;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = null;
        ListNode head = null;
        boolean isFirst = true;
        int carry = 0;

        while (l1 != null && l2 != null) {


            int sum = l1.val + l2.val;

            if (carry > 0) {
                sum = sum + carry;
            }
            carry = sum / 10;
            sum = sum % 10;

            if (isFirst) {
                result = new ListNode(sum);
                head = result;
                isFirst = false;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }


        while (l1 != null) {
            int sum = l1.val;

            if (carry > 0) {
                sum = sum + carry;
            }
            carry = sum / 10;
            sum = sum % 10;
            result.next = new ListNode(sum);
            result = result.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val;

            if (carry > 0) {
                sum = sum + carry;
            }
            carry = sum / 10;
            sum = sum % 10;
            result.next = new ListNode(sum);
            result = result.next;
            l2 = l2.next;
        }
        if (carry>0) result.next = new ListNode(carry);
        return head;


    }

    public static void main(String[] args) {
        ListNode list = new ListNode(7);
        list.next = new ListNode(5);
        list.next.next = new ListNode(9);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(6);

        // creating seconnd list
        ListNode list2 = new ListNode(8);
        list2.next = new ListNode(4);

        ListNode result = new AddTwoNumbers().addTwoNumbers(list, list2);

        System.out.println(result);
    }
}
