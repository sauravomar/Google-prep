package main.leetcode;

public class PallindromeLinkList {

    public boolean isPalindrome(ListNode head) {

        int totalNode = 0;
        ListNode slow = head;

        while (slow != null) {
            slow = slow.next;
            totalNode++;
        }
        slow = head;
        int mid = (totalNode + 1) / 2;
        ;


        while (mid > 0) {
            mid--;
            slow = slow.next;
        }

        ListNode reverse = reverse(slow);
        slow = head;

        while (slow != null && reverse != null) {
            if (slow.val == reverse.val) {
                slow = slow.next;
                reverse = reverse.next;
            } else {
                return false;
            }
        }
        return true;

    }

    private ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(1))));
        System.out.println(new PallindromeLinkList().isPalindrome(head));
    }
}


