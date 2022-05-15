class ListNode{
    public int val;
    public ListNode next;

}

public class T1 {
    public static ListNode reverse(ListNode head){
        ListNode dummy;
        ListNode first;
        ListNode last;
        //0,1
        if(head==null || head.next==null){
            return head;
        }
        //2
        else if(head.next.next==null){
            first=head.next;
            last=head;
            first.next=last;
            return first;
        }
        else{
            first=head.next;
            last=head;
            while(first.next!=null){
                dummy=first.next;
                first.next=last;
                last=first;
                first=dummy;
            }
            return first;
        }
    }

}
