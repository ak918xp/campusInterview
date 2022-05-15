import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class t1 {
    //m,n
    //
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //表示从当前位置开始过m个人那个人出列
        int m=input.nextInt();
        //表示初始状态下一共有多少个人
        int n = input.nextInt();
        int[] num = new int[n];
//        List<Integer> num2 =new LinkedList<>(n);
        for(int i=0;i<n;i++){
            num[i]=1;
        }
        outOperation(num,m,n);
    }

    public static void outOperation(int[] num,int m,int n){
        int length=num.length;
        int count=num.length;
        int cur=0;
        //如果这个圈里面的人数大于1
        while(count>1){
            //执行出圈查找
            int times = m;
            //一直找到次数用完
            while(times!=0){
                //数一下当前这个位置有没有人，有人的话就累加
                if(times>0 && num[cur]!=0){
                    cur=cur+1;
                    cur=judge(length,cur);
                    times--;
                }
                else{
                    cur++;
                    cur=judge(length,cur);
                }
            }
            //当一次查找次数用完
            //当本位置没有人
            while(num[cur]==0){
                cur++;
                cur=judge(length,cur);
            }
            //当本位制有人，让该位置出圈,人数减一
            if(num[cur]==1){
                num[cur]=0;
                count--;
                cur++;
                judge(length,cur);
            }
        }
    }

    //判断当前指针是否越界
    private static int judge(int length,int cur) {
        if(cur>length-1){
            cur=cur-length;
        }
        return cur;
    }
}
