import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/24 19:50
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<List<Integer>> grid = new ArrayList<>();
        for(int i=1;i<=n;i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=1;j<=i;j++){
                tmp.add(input.nextInt());
            }
            grid.add(tmp);
        }
        int[][] res = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){//起点
                    res[i][j]=grid.get(0).get(0);
                }
                else if(i!=0 && j==0){//第一列
                    res[i][j]=res[i-1][j]+ grid.get(i).get(0);
                }
                else if(i<j){//大于斜边的境外势力
                    res[i][j]=0;
                }
                else if(i==n-1){//底边
                    res[i][j]=res[i-1][j]+grid.get(i).get(j);
                }
                else if(i==j){//斜边
                    res[i][j]=res[i][j-1]+grid.get(i).get(j);
                }
                else{
                    res[i][j]=Math.max(res[i-1][j],res[i][j-1])+grid.get(i).get(j);
                }
            }
        }
        int max=-1;
        for(int i=0;i<n;i++){
            if(max<res[n-1][i]){
                max=res[n-1][i];
            }
        }
        System.out.println(max);
    }
}
