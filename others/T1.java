public class T1 {
    public static ListNode sum(ListNode list1,ListNode list2){
        ListNode res = new ListNode(-1);
        ListNode head=res;
        int tmp=0,now=0;
        while(list1!=null || list2!=null){
            if(list1!=null){
                now=list1.val+tmp;
            }
            else if(list2!=null){
                now=list2.val+tmp;
            }
            else{
                now=list1.val+list2.val+tmp;
            }

            tmp=now/10;
            now=now%10;
            head.next=new ListNode(now);
            head=head.next;
            list1=list1.next;
            list2=list2.next;
        }
        return res.next;
    }
}
