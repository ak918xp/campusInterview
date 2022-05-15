import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/26 20:31
 */
public class T5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[][] points = new double[n][2];
        for(int i=0;i<n;i++){
            points[i][0]=input.nextDouble();
            points[i][1]=input.nextDouble();
        }
        System.out.println(3*n/4);
    }
}
