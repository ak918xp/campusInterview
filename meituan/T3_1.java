import java.util.Scanner;
import java.util.Stack;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/8 11:01
 */
public class T3_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n =input.nextInt();
        int[] inputParam = new int[n+1];
        for(int i=1;i<=n;i++){
            inputParam[i]=input.nextInt();
        }
//        Long res = calculate(n,inputParam);
//        System.out.println(res);
    }

//    static Stack<Integer> max = new Stack<>();
//    static Stack<Integer> pre = new Stack<>();
//    public static Long calculate(int n,int[] num){
//        int[] max = new int[n+1];
//        int[] pre = new int[n+1];
//        max[0]=0;
//        pre[0]=0;
//        int mark=2;
//        int length=n+1;
//        for(int i=2;i<length;i++){
//            //当前数大于之前的最大数
//            if(num[i]>max[mark-1]){
//                max[mark]=num[i];
//                pre[mark]=max[mark];
//                mark++;
//            }
//            else{
//                max[mark]=max[mark-1];
//                Stack<Integer> tmpMax = new Stack<>();
//
//            }
//        }
//    }
}
