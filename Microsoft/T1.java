import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/16 19:39
 */
public class T1 {
    public static void main(String[] args){
        int[] A = new int[]{51,71,17,42};
        int res = solution(A);
        System.out.println(res);
    }

    static Map<Integer, List<Integer>> map;
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max=-1;
        map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            calculate(A[i]);
        }
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.size()>1){
                Collections.sort(list);
                int tmp = list.get(list.size()-1)+list.get(list.size()-2);
                if(max<tmp){
                    max=tmp;
                }
            }
        }
        return max;
    }

    public static void calculate(int num){
        int param=num;
        int res=0;
        while(param>0){
            res+=(param%10);
            param/=10;
        }
        if(map.containsKey(res)){
            List<Integer> list = map.get(res);
            list.add(num);
            map.put(res,new ArrayList<>(list));
        }
        else{
            List<Integer> list = new ArrayList<>();
            list.add(num);
            map.put(res,new ArrayList<>(list));
        }
    }
}
