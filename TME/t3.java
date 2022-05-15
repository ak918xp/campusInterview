import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/16 19:35
 */
public class t3 {
    public static void main(String[] args){
        System.out.println(minM(10,10));
    }

    public static int minM(int n,int k){
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        for(int i=1;i<=Integer.MAX_VALUE;i++){
            int now = dp.get(i-1)+count1(i,k);
            if(now>=n){
                return i;
            }
            dp.add(now);
        }
        return -1;
    }

    public static int count1(int num,int stage){
        int count=0;
        while(num!=0){
            if(num%stage==1){
                count++;
            }
            num/=stage;
        }
        return count;
    }
}
