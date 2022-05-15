import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T2 {
    public static int[][] path = new int[101][101];
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=input.nextInt();
            }
        }
        floyd(matrix);
    }

    private static void floyd(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                path[i][j]=-1;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j< matrix.length;j++){
                if(i!=j){
                    if(matrix[i][j]==0);
                }
                else{
                    res.add(matrix[i][j]) ;
                    findPath(i,j);
                }
            }
        }
    }

    public static void findPath(int i,int j){
        int m=path[i][j];
        if(m==-1){
            return;
        }
        findPath(i,m);
        findPath(m,j);
    }

}