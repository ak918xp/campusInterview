public class ListNode {
    private int val;
    private ListNode next;
    public ListNode(int val){
        this.val=val;
    }

    public int getVal(){
        return val;
    }

    public ListNode getNext(){
        return next;
    }

    public void setNext(int val){
        next= new ListNode(val);
    }
}
