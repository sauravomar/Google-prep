package main.linklist;

public class FlattenLinkList {

    public DoubleLinkList flatten(DoubleLinkList head) {
        if(head == null) return head;
        return normal(head);
    }


    public DoubleLinkList normal(DoubleLinkList head){

        DoubleLinkList curr =  head;

        while(curr.child == null && curr.next!=null){
            curr = curr.next;
        }

        if(curr.child !=null){
            DoubleLinkList node =  normal(curr.child);
            DoubleLinkList last = getLastNode(node);

            node.prev = curr;
            DoubleLinkList next =  curr.next;
            curr.next = node;
            last.next = next;

            if(last.next != null) last.next.prev = last;

            curr.child = null;
        }

        return  head;

    }


    public  DoubleLinkList getLastNode(DoubleLinkList node){

        DoubleLinkList curr = node;

        while(curr.next!=null){
            curr = curr.next;
        }
        return curr;
    }

    public  void printFlattenNodes(DoubleLinkList head)
    {
        DoubleLinkList curr=head;
        while(curr!=null)
        {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }

    }


    public static void main(String[] args) {


        DoubleLinkList four=new DoubleLinkList(4);
        DoubleLinkList six=new DoubleLinkList(6);
        DoubleLinkList three=new DoubleLinkList(3);
        DoubleLinkList two=new DoubleLinkList(2);
        DoubleLinkList one=new DoubleLinkList(1);
        DoubleLinkList five=new DoubleLinkList(5);

//        four.prev = three;
//        three.prev = two;
//        three.next = four;
//
//        two.next = three;
//        two.prev = one;
//
//        five.next = six;
//        six.prev = five;
//
//        one.next = two;
//        two.child = five;

         one.child = three;
         one.next = two;
         two.prev = one;

        FlattenLinkList obj = new FlattenLinkList();
        obj.flatten(one);

        obj.printFlattenNodes(one);

    }
}
