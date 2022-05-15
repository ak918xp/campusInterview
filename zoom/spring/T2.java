import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/2/19 20:04
 */
public class T2 {
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        String param = input.nextLine();
        String res = doWorks(param);
        System.out.println(res);
    }
    public static String doWorks(String param){
        char[] ch = param.toCharArray();
        if(ch[0]<='0'||ch[0]>'9'){
            if(ch[0]=='-' || ch[0]=='+'){

            }
            else{
                return "0";

            }
        }
        Long l = Long.valueOf(param);
        if(l>Integer.MAX_VALUE || l<Integer.MIN_VALUE){
            return "0";

        }
        for(int i=1;i< ch.length;i++){
            if(ch[i]<'0' || ch[i]>'9'){
                return "0";
            }
        }

        return param;
    }
}
