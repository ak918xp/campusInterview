import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T4 {
    public static void main(String[] args){
        int[] A = new int[]{7,3,7,3,1,3,4,1};
        System.out.println(Solution(A));
    }

    public static int Solution(int[] A){
        int length=A.length;
        int max =0;
        Set<Integer> statistic = new HashSet<>();
        for(int n:A){
            if(!statistic.contains(n)){
                statistic.add(n);
            }
        }
        max=statistic.size();
        int windowSize=max;
        while(windowSize<=length){
            for(int i=0;i<length-windowSize;i++){
                Set<Integer> set = new HashSet<>();
                for(int j=i;j<i+windowSize;j++){
                    if(!set.contains(A[j])){
                        set.add(A[j]);
                        if(set.size()==max){
                            return windowSize;
                        }
                    }
                }
            }
            windowSize++;
        }
        return -1;
    }
}
