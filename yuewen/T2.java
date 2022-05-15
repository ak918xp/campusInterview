import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/21 20:38
 */
public class T2 {
    public static void main(String[] args){

    }

    public static int findLucky (int[] arr) {
        // write code here
        int res=-1;
        Map<Integer ,Integer> map = new HashMap<>();
        for(int i=0;i< arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet() ){
            int key = m.getKey();
            int value = m.getValue();
            if(key==value && key>res){
                res=key;
            }
        }
        return res;
    }
}
