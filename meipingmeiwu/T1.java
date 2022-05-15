import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/26 19:01
 */
public class T1 {

    public boolean wordPattern (String pattern, String str) {
        // write code here
        Map<Character,String> map = new HashMap<>();
        String[] params = str.trim().split(" ");
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(params[i])){
                    return false;
                }
            }
            else{
                map.put(c,params[i]);
            }
        }
        return true;
    }
}
