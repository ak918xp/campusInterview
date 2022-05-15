import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/17 15:23
 */
public class T1 {
    public static boolean makesquare (int[] matchsticks) {
        // write code here
        int length = matchsticks.length;
        int total=0;
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(matchsticks);
        for(int i=0;i<length;i++){
            total+=matchsticks[i];
            map.put(matchsticks[i],map.getOrDefault(matchsticks[i],0)+1);
        }
        if(total%4!=0){
            return false;
        }
        int edge=total/4;
        if(matchsticks[length-1]>edge){
            return false;
        }
        return true;
    }
}
