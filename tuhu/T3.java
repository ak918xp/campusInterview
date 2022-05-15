import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/30 19:29
 */
public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int w = input.nextInt();
        List<int[]> tasks = new ArrayList<>();
        for(int i=0;i<w;i++){
            int[] task = new int[2];
            task[0]=input.nextInt();
            task[1]=input.nextInt();
            tasks.add(task);
        }
        //dp[i][j]表示前i个任务，用了j大小内存时
        int[][] dp =new int[w][m+1];
        for(int i=0;i<w;i++){
            for(int j=1;j<=m;j++){
                if(i==0){
                    if(tasks.get(i)[0]<=j){
                        dp[i][j]=tasks.get(i)[1];
                    }
                }
                else if(tasks.get(i)[0]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    if(i>0){
                        dp[i][j]=Math.max(dp[i-1][j-tasks.get(i)[0]]+tasks.get(i)[1],dp[i-1][j]);
                    }
                }
            }
        }
        System.out.println(dp[w-1][m]);
    }
}
