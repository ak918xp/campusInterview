import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/29 19:54
 */
public class T1 {
    static int count;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        count=0;
        for(int i=m;i<=n;i++){
            if(judge(i)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean judge(int num){
        String strNum = Integer.toString(num);
        int length=strNum.length();
        for(int i=0;i<length;i++){
            char sg = strNum.charAt(i);
            if(i!=length-1){
                String db = strNum.substring(i,i+2);
                if(sg=='6'){
//                    System.out.println(num);
                    return true;
                }
                if("17".equals(db)){
//                    System.out.println(num);
                    return true;
                }
            }
            else{
                if(sg=='6'){
//                    System.out.println(num);
                    return true;
                }
            }
        }
        return false;
    }
}
