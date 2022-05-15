import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/16 20:01
 */
public class T2 {

    public static int solution(int N, int[] A, int[] B) {
        // write your code in Java SE 8
        Map<Integer,Integer> count = new HashMap<>();
        for(int i : A){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        for(int i : B){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        int res=0;
        while(count.size()>0){
            int freq=0;
            int mark=Integer.MAX_VALUE;
            for(Map.Entry<Integer,Integer> map : count.entrySet()){
                if(freq<map.getValue()){
                    freq=map.getValue();
                    mark=map.getKey();
                }
            }
            res+=(freq*N);
            count.remove(mark);
            N--;
        }
        return res;
    }
}
