import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/30 19:13
 */
public class T1 {
    public static void main(String[] args){
        Scanner input  =new Scanner(System.in);
        int num = input.nextInt();
        int res = countTiger(num);
        System.out.println(res);
    }

    static int num=2;
    public static int countTiger (int month) {
        num=dfs(month,0);
        return num;
    }

    public static int dfs(int month,int born){
        while(month>0){
            month-=3;
            if(month>0){
                num=num+dfs(month,2);
            }
            else{
                return born;
            }
        }
        return born;
    }
}
