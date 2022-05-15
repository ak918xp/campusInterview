import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/7 19:31
 */
public class T1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int size=input.nextInt();
        int[][] before = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                before[i][j]=input.nextInt();
            }
        }
        int[][] after = new int[size*n][size*n];
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                for(int a=0;a<size;a++){
                    for(int b=0;b<size;b++){
                        after[size*i+a][size*j+b]=before[i][j];
                    }
                }
            }
        }
        for(int i=0;i<size*n;i++){
            for(int j=0;j<size*n;j++){
                System.out.print(after[i][j]+" ");
            }
            System.out.println();
        }
    }
}
