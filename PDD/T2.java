import java.util.*;

public class T2 {
    static Stack<Integer> common = new Stack<>();
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Queue<Integer> chicken = new LinkedList<>();
        Queue<Integer> duck = new LinkedList<>();

        for(int i=0;i<n;i++){
            chicken.offer(input.nextInt());
        }
        for(int i=0;i<n;i++){
            duck.offer(input.nextInt());
        }
        int flag=1;
        while(chicken.size()>0 || duck.size()>0) {
            Stack<Integer> tmpRes = new Stack<>();
            //拼拼鸡
            if((flag%2!=0 && chicken.size()>0) || duck.size()==0){
                int now = chicken.poll();
                judge(now,chicken,tmpRes);
            }
            //拼拼鸭
            else if((flag%2==0 && duck.size()>0) || chicken.size()==0){
                int now = duck.poll();
                judge(now,duck,tmpRes);
            }
            flag++;
        }

    }

    public static void judge(int now,Queue<Integer> turn,Stack<Integer> tmpRes){
        //把排放到桌面上
        common.push(now);
        //如果桌子上有
        if(set.contains(now)){
            //找到桌子上第一张
            while(common.peek()!=now){
                int storeNow=common.peek();
                tmpRes.push(storeNow);
                set.remove(common.pop());
            }
            //收到手牌
            while(tmpRes.size()>0){
                turn.offer(tmpRes.pop());
            }
            int newNow =turn.poll();
            judge(newNow,turn,tmpRes);
        }
        else{
            common.push(now);
        }
        set.add(now);
    }

}
