import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/21 16:12
 */
public class T4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputParam = input.nextLine();
        inputParam = inputParam.substring(1,inputParam.length()-1);
        inputParam = inputParam.substring(1,inputParam.length()-1);
        String[] inputParams = inputParam.split("],\\[");
        List<int[]> grid = new ArrayList<>();
        for(int i=0;i<inputParams.length;i++){
            String[] tmpStr=inputParams[i].split(",");
            int[] gridLine = new int[tmpStr.length];
            for(int j=0;j<tmpStr.length;j++){
                gridLine[j]=Integer.parseInt(tmpStr[j]);
            }
            grid.add(gridLine);
        }
//        System.out.println(1);
        System.out.println(count(grid));
    }

    public static int count(List<int[]> gridList){
        int row=gridList.size();
        int column=gridList.get(0).length;
        int[][] grid = new int[row][column];
        for(int i=0;i<row;i++){
            grid[i]=gridList.get(i);
        }
        int[][] dp = new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(i==0 && j ==0){
                    dp[0][0]=0;
                }
                //水或者陆地
                else if(grid[i][j]==0 || grid[i][j]==1){
                    int fromUp=Integer.MAX_VALUE,fromDown=Integer.MAX_VALUE,fromLeft=Integer.MAX_VALUE,fromRight=Integer.MAX_VALUE;
                    if(0<=i-1){
                        fromUp=dp[i-1][j];
                    }
                    if(i+1<row){
                        fromDown=dp[i+1][j];
                    }
                    if(0<=j-1){
                        fromLeft=dp[i][j-1];
                    }
                    if(j+1<column){
                        fromRight=dp[i][j+1];
                    }
                    int preCost = Math.min(fromUp,Math.min(fromDown,Math.min(fromLeft,fromRight)));
                    if(preCost==Integer.MAX_VALUE){
                        dp[i][j]=Integer.MAX_VALUE;
                    }
                    else{
                        dp[i][j]= grid[i][j]==0?preCost+2:preCost+1;
                    }
                }
                //障碍物
                else if(grid[i][j]==2){
                    dp[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        return dp[row-1][column-1];
    }
}
