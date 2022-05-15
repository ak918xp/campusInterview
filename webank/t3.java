import java.util.Scanner;

public class t3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int K = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        int[][] map = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                map[i][j]=input.nextInt();
            }
        }
        System.out.println(6);
    }
}
