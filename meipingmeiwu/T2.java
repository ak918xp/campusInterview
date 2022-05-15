/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/26 19:07
 */
public class T2 {
    public static boolean limiter (int threshold, int periodSeconds) {
        // write code here
        if(60*periodSeconds>threshold){
            return false;
        }
        return true;
    }
}
