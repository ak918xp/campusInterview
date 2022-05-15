package autumn;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/22 15:41
 */
public class T2 {
    public static void main(String[] args){
        ArrayList<Integer> cases = new ArrayList<Integer>();
        cases.add(1);
        cases.add(2);
        cases.add(9);
        int res = minEffort(cases);
        System.out.println(res);
    }

    public static int minEffort(ArrayList<Integer> cases) {
       int length=cases.size();
       int mark=0;
       int count=0;
       while(mark<length-1){
           Collections.sort(cases);
           int tmp=cases.get(mark)+cases.get(mark+1);
           count+=tmp;
           cases.set(mark,0);
           cases.set(mark+1,tmp);
           mark++;
       }
       return count;
    }
}
