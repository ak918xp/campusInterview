import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/30 20:02
 */
public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int strength = input.nextInt();
        int valueCapacity=input.nextInt();
        int[] value = new int[valueCapacity];
        for(int i=0;i<valueCapacity;i++){
            value[i]=input.nextInt();
        }
        int consumeCapacity=input.nextInt();
        int[] consume = new int[consumeCapacity];
        for(int i=0;i<consumeCapacity;i++){
            consume[i]=input.nextInt();
        }
        int capacity=valueCapacity;
        int[][] dp =new int[capacity][strength+1];
        for(int i=0;i<capacity;i++){
            for(int j=0;j<=strength;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(consume[i]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-consume[i]]+value[i]);
                }
            }
        }
        System.out.println(dp[capacity-1][strength]);
    }
}
