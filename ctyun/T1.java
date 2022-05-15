import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/30 19:13
 */
public class T1 {
    public static void main(String[] args){
        Scanner input  = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[][] inputParams = new int[n][2];
        String[] params = new String[n];
        for(int i=0;i<n;i++){
            params[i] = input.nextLine();
        }
        for(int i=0;i<n;i++){
            String[] tmpParam=params[i].split(",");
            for(int j=0;j< tmpParam.length;j++){
                inputParams[i][j]=Integer.parseInt(tmpParam[j]);
                inputParams[i][j]=Integer.parseInt(tmpParam[j]);
            }
        }
//        int[][] mergedLine=merge(inputParams);
        int res = countLength(inputParams);
        System.out.println(res+1);
    }

    public static int countLength(int[][] mergedLine){
        int res=0;
        int length=mergedLine.length;
        int endPoint=-1;
        for(int i=0;i<length;i++){
            if(mergedLine[i][1]>endPoint){
                endPoint=mergedLine[i][1];
            }
        }
        int[] markLine = new int[endPoint+1];
        for(int i=0;i<length;i++){
            int start=mergedLine[i][0];
            int end = mergedLine[i][1];
            for(int j=start;j<end;j++){
                markLine[j]++;
            }
        }
        for(int i=0;i<=endPoint;i++){
            if(markLine[i]==1){
                res++;
            }
        }
        return res;
    }
}
