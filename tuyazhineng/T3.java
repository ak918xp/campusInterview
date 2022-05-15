import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/15 14:39
 */
public class T3 {
    public static void main(String[] args){
        String str1 = "abcabc";
        String str2 = "abc";
        int res = doWorks(str1,str2);
        System.out.println(res);
    }
    public static int doWorks(String str1,String str2){
        Map<String ,Integer> map = new HashMap<>();
        int length=str2.length();
        for(int i=0;i<=str1.length()-length;i++){
            String tmp = str1.substring(i,i+length);
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        return map.get(str2);
    }
}
