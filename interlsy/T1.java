/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/15 19:07
 */

public class T1 {

    public static ListNode reverseList(ListNode head){
        ListNode last = null;
        ListNode reversedHead=head;
        ListNode cur = head;
        while(cur!=null){
            ListNode first = cur.next;
            if(first==null){
                reversedHead=cur;
            }
            cur.next=last;
            last=cur;
            cur=first;
        }
        return reversedHead;
    }

    public static ListNode reverseKList(ListNode head,int k){
        ListNode node = head;
        if(head==null){
            return null;
        }
        int count = k;
        while(count>0){
            head=head.next;
            if(head==null){
                return node;
            }
        }
        k=count;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(node);
        ListNode dummy = newHead;
        while(dummy.next!=null){
            dummy=dummy.next;
        }
        dummy.next = reverseKList(next,k);
        return newHead;
    }
}
