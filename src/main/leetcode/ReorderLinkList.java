package main.leetcode;

import java.util.List;

public class ReorderLinkList {

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public void reorderList(ListNode head) {

    }


    public int getTotalNodes(ListNode head){

        int count =0;

        ListNode tempNode = head;

        while(tempNode !=null){
            count++;
            tempNode = tempNode.next;
        }

        return  count;
    }


    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;


        while (next !=null){

        }

        return  prev;
    }
}


