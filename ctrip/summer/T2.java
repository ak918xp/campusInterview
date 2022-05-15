import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T2 {
    public static void main(String[] args){
        int[] num = new int[]{1,2,1,7,9,4};
        System.out.println(collide(num));
    }

    public static int collide(int[] numbers) {
        List<Integer> num = new ArrayList<>();
        for (int number : numbers) {
            num.add(number);
        }
        Collections.sort(num);
        while(num.size()!=1){
            int big=num.get(num.size()-1);
            int small=num.get(num.size()-2);
            int ans=big-small;
            num.remove(num.size()-1);
            num.remove(num.size()-1);
            num.add(ans);
            Collections.sort(num);
        }
        return num.get(0);
    }
}
