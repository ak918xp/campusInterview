import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/8 10:38
 */
public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n =input.nextInt();
        int[] inputParam = new int[n+1];
        for(int i=1;i<=n;i++){
            inputParam[i]=input.nextInt();
        }
        Long res = calculate1(n,inputParam);
        System.out.println(res);
    }

    private static Long calculate1(int n, int[] inputParam) {
        int[] pre = new int[n+1];
        for(int i=1;i<inputParam.length;i++){
            int now = inputParam[i];
            int max = 0;
            for(int j=0;j<=i;j++){
                if(inputParam[j]<now && max<inputParam[j]){
                    max=inputParam[j];
                }
            }
            pre[i]=max;
        }
        Long res = 0L;
        for(int i=1;i<=n;i++){
            res+=((long) pre[i] *i);
        }
        return res;
    }
}
