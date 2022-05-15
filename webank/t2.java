import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class ListNode{
    Long value;
    ListNode next;
    public ListNode(Long val){
        this.value = val;
    }
}
public class t2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ListNode head = new ListNode((long) 0.0);
        ListNode point = head;
        Long[] fighter = new Long[n];
        for(int i=0;i<n;i++){
            fighter[i] = input.nextLong();
        }
        for(int i=n-1;i>=0;i--){
            ListNode tmp = new ListNode(fighter[i]);
            point.next=tmp;
            point=point.next;
        }
        ListNode first=head.next;
        ListNode last=head;
        while(first!=null){
            if(first.value<last.value){
                first=first.next;
                last.next=first;
            }
            else{
                first=first.next;
                last=last.next;
            }
        }
        ListNode now = head;
        int count=0;
        List<Long> res = new ArrayList<Long>();
        while(now!=null){
//            System.out.print(now.value+" ");
            if(now.value!=0){
                res.add(now.value);
                count++;
            }
            now=now.next;
        }
        System.out.println(count);
        for(int i=res.size()-1;i>=0;i--){
            System.out.print(res.get(i)+" ");
        }
    }
}
