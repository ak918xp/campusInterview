import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class T1 {
    public static void main(String[] args){
        int flag = convertTime("01:00");
        System.out.println(flag);
    }

    public static int countMaxActivity (ArrayList<ArrayList<String>> timeSchedule) {
        // write code here
        Collections.sort(timeSchedule, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                String time1=o1.get(0);
                String time2=o2.get(0);
                return convertTime(time1)-convertTime(time2);
            }
        });
        return 0;
    }

    public static int convertTime(String time){
        int res=0;
        String s1=time.substring(0,2);
        String s2=time.substring(3,5);
        int i1=Integer.parseInt(s1);
        int i2=Integer.parseInt(s2);
        res=i1*60+i2;
        return res;
    }
}
