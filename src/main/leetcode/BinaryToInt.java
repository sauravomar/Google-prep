package main.leetcode;

public class BinaryToInt {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;

        StringBuilder sb = new StringBuilder();
        ListNode temp = head;

        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
    }
}
