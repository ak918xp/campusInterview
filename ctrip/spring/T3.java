import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/11/8 19:56
 */
public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] params = new int[n];
        for(int i=0;i<n-1;i++){
            params[i]=input.nextInt();
        }
        int[] nodes = new int[n+1];
        for(int i=0;i<n-1;i++){
            nodes[params[i]]++;
        }
        Arrays.sort(nodes);
        System.out.println(nodes[n]);
    }
}
