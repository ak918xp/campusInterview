import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/26 20:07
 */
public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] person = new int[N];
        for(int i=0;i<N;i++){
            person[i]=input.nextInt();
        }
        int[][] path = new int[N-1][3];
        for(int i=0;i<N-1;i++){
            path[i][0]=input.nextInt();
            path[i][1]=input.nextInt();
            path[i][2]=input.nextInt();
        }
        int totalCost=0;
        int[][] grid = createMatrix(path,N);
        for(int i=0;i<N;i++){
            totalCost+=path[i][2]* person[i];
        }
    }

    public static int dijkstra(int[][]grid, int start,int end){
        boolean[] isLabel=new boolean[grid[0].length];
        int[] indexs = new int[grid[0].length];
        int i_count=-1;
        return -1;
    }

    public static int[][] createMatrix(int[][] path,int N){
        int[][] grid = new int[N][N];
        for(int i=0;i<path.length;i++){
            int x = path[i][0];
            int y = path[i][1];
            int value = path[i][2];
            grid[x][y]=value;
            grid[y][x]=value;
        }
        return grid;
    }
}
