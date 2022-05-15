import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/27 20:50
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] array = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                array[i][j]=input.nextInt();
            }
        }
        int res = pathSum(array);
        System.out.println(res);
    }

    public static int pathSum(int[][] array){
        int[][] res = new int[array.length][array[0].length];
        for(int i=0;i<res[0].length;i++){
            res[0][i] = array[0][i];
        }
        for(int i=1;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                int one = j-1,two=j,three=j+1;
                int preMax=res[i-1][two];
                if(one>=0){
                    preMax=Math.max(preMax,res[i-1][one]);
                }
                if(three<array[0].length){
                    preMax=Math.max(preMax,res[i-1][three]);
                }
                res[i][j]=preMax+array[i][j];
            }
        }
        int ans=0;
        for(int i=0;i<res[0].length;i++){
            if(res[res.length-1][i]>ans){
                ans=res[res.length-1][i];
            }
        }
        return ans;
    }
}
