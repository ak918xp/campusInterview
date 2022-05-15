import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/5 17:25
 */
public class T2 {
    public static void main(String[] args){
        long[] loginTime=new long[]{1628352002, 1628352072, 1628352125};
        logintCount(null,loginTime);
    }
    public static String[] logintCount (String[] loginAccount, long[] loginTime) {
        // write code here
        Arrays.sort(loginTime);
        for(int i=0;i< loginTime.length;i++){
            long timestamp=loginTime[i];
            Date time= new Date(timestamp);
            System.out.println(time);
        }
        return null;
    }
}
