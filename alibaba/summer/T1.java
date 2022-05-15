import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/6 19:02
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //d day a month
        int d = input.nextInt();
        //m month
        int m = input.nextInt();
        //w day a week
        int w = input.nextInt();
        //i day
        int i = input.nextInt();
        //j month
        int j = input.nextInt();
        //k year
        int k = input.nextInt();
        char res = findAlpha(d,m,w,i,j,k);
        System.out.println(res);
    }

    public static char findAlpha(int d,int m,int w,int i,int j,int k){
        //init
        long monthDay=d;
        long yearDay=m*d;
        //convert to nth day
        long n = yearDay*(k-1)+monthDay*(j-1)+i;
        Long res = n%w;
        int resInt = res.intValue();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        char resChar;
        if(resInt==0){
            resInt+=w;
        }
        resChar = alpha.charAt(resInt-1);
        return resChar;
    }
}
