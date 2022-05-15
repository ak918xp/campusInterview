public class T1 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.setNext(2);
        System.out.println(sum(head));
    }

    public static int sum(ListNode head){
        int sum=0;
        ListNode now=head;
        while(now!=null){
            sum+=now.getVal();
            now=now.getNext();
        }
        return sum;
    }
}
