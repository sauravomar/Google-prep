package main.linklist;

public class DoubleLinkList {

    int val;
    DoubleLinkList next;
    DoubleLinkList prev;
    DoubleLinkList child;
    DoubleLinkList(int x) { val = x; }

    DoubleLinkList(int x, DoubleLinkList prev, DoubleLinkList next, DoubleLinkList child) {
        val = x;
        this.prev = prev;
        this.next = next;
        this.child = child;


    }

}
