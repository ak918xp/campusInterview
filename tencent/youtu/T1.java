/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/12/21 11:21
 */
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val=val;
    }
}
public class T1 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode res = reverseList(l1);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }



    public static ListNode reverseList(ListNode head){
        if(head==null){
            return null;
        }
        else if(head!=null && head.next==null){
            return head;
        }
        else if(head.next!=null && head.next.next==null){
            ListNode pre=head.next;
            ListNode cur=head;
            pre.next = cur;
            cur.next=null;
            return pre;
        }
        else{
            ListNode first = head.next.next;
            ListNode mid = head.next;
            ListNode last=head;
            while(first!=null){
                mid.next=last;
                if(last==head){
                    last.next=null;
                }
                last=mid;
                mid=first;
                first=first.next;
            }
            mid.next=last;
            return mid;
        }
    }
}
