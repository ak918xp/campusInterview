/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/15 19:24
 */
public class T2 {
    public static void main(String[] args){
        int n = 3;
        int res = climbStairs(n);
        System.out.println(res);
    }

    public static int climbStairs (int n) {
        // write code here
        int[] num = new int[n+1];
        num[0]=1;
        num[1]=1;
        for(int i=2;i<=n;i++){
            num[i]=num[i-1]+num[i-2];
        }
        return num[n];
    }
}
