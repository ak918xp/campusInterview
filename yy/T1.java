import java.util.HashSet;
import java.util.Set;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/5 17:20
 */
public class T1 {

    public long PrimeSum (int num) {
        // write code here
        Set<Integer> set = new HashSet<>();
        for(int i=2;i<=num;i++){
            if(!set.contains(i)){
                for(int j=2;i*j<=num;j++){
                    set.add(i*j);
                }
            }
        }
        long count=0;
        for(int i=2;i<=num;i++){
            if(!set.contains(i)){
                count+=i;
            }
        }
        return count;
    }
}
