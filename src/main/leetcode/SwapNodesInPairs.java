package main.leetcode;

public class SwapNodesInPairs {


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = null;
        ListNode next = head;

        boolean isFirst = true;

        while (next.next != null) {

            ListNode temp = next.next;
            next.next = next.next.next;
            temp.next = next;

            if(isFirst){
                head = temp;
                isFirst = false;
                curr = next;
            }else{
                curr.next = temp;
            }

            if (next.next == null) break;
            curr = next;
            next = next.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        SwapNodesInPairs obj = new SwapNodesInPairs();
        ListNode result = obj.swapPairs(one);

        System.out.println(result);

    }


}
