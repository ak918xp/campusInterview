import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/26 19:51
 */
public class T2 {
    static int count;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        count=0;
        int N = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();
        for(int i=A;i<=B;i++){
            calculate(i,N);
        }
        System.out.println(count);
    }

    public static void calculate(int i,int N){
        int num=0;
        while(i>0){
            num+=(i%10);
            i=i/10;
        }
        if(num%N==0){
            count++;
        }
    }
}
