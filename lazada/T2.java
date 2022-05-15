import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/1 10:13
 */
public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputParam= input.nextLine();
        inputParam=inputParam.trim();
        int length=inputParam.length();
        Set<Character> set = new HashSet<>();
        int left=0,right=0;
        int maxLength=0;
        while(right<length){
            while(set.contains(inputParam.charAt(right))){
                set.remove(inputParam.charAt(left++));
            }
            set.add(inputParam.charAt(right++));
            if(set.size()>maxLength){
                maxLength=set.size();
            }
        }
        System.out.println(maxLength);
    }
}
