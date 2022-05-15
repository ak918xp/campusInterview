import java.util.Locale;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/8 10:31
 */
public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputParam = input.nextLine();
        String res = recovery(inputParam);
        System.out.println(res);
    }

    public static String recovery(String inputParam){
        inputParam=inputParam.trim();
        StringBuilder sb = new StringBuilder();
        char pre='0';
        for(int i=0;i<inputParam.length();i++){
            char now = inputParam.charAt(i);
            if(pre!=now && now!=' '){
                sb.append(now);
                pre=now;
            }
        }
        return sb.toString();
    }
}
